#include <stdexcept>
#include "cqcode.h"

inline void replace_string(std::string& str, const std::string& from, const std::string& to) {
    size_t startPos = 0;
    while ((startPos = str.find(from, startPos)) != std::string::npos) {
        str.replace(startPos, from.length(), to);
        startPos += to.length();
    }
}

inline int utf8_next_len(const std::string& str, size_t offset)
{
    uint8_t c = (uint8_t)str[offset];
    if (c >= 0xFC)
        return 6;
    else if (c >= 0xF8)
        return 5;
    else if (c >= 0xF0)
        return 4;
    else if (c >= 0xE0)
        return 3;
    else if (c >= 0xC0)
        return 2;
    else if (c > 0x00)
        return 1;
    else
        return 0;
}


void decode_cqcode(const std::string& code, std::vector<std::unordered_map<std::string, std::string>>& dest) {
    std::string cache;
    bool is_start = false;
    std::string key_tmp;
    std::unordered_map<std::string, std::string> kv;
    for(size_t i = 0; i < code.size(); i++) {
        int utf8_char_len = utf8_next_len(code, i);
        if(utf8_char_len == 0) {
            continue;
        }
        std::string_view c(&code[i],utf8_char_len);
        if (c == "[") {
            if (is_start) {
                throw illegal_code();
            } else {
                if (!cache.empty()) {
                    std::unordered_map<std::string, std::string> kv;
                    replace_string(cache, "&#91;", "[");
                    replace_string(cache, "&#93;", "]");
                    replace_string(cache, "&amp;", "&");
                    kv.emplace("_type", "text");
                    kv.emplace("text", cache);
                    dest.push_back(kv);
                    cache.clear();
                }
                std::string_view cq_flag(&code[i],4);
                if(cq_flag == "[CQ:"){
                    is_start = true;
                    i += 3;
                }else{
                    cache += c;
                }
            }
        }
        else if (c == "=") {
            if (is_start) {
                if (cache.empty()) {
                    throw illegal_code();
                } else {
                    if (key_tmp.empty()) {
                        key_tmp.append(cache);
                        cache.clear();
                    } else {
                        cache += c;
                    }
                }
            } else {
                cache += c;
            }
        }
        else if (c == ",") {
            if (is_start) {
                if (kv.count("_type") == 0 && !cache.empty()) {
                    kv.emplace("_type", cache);
                    cache.clear();
                } else {
                    if (!key_tmp.empty()) {
                        replace_string(cache, "&#91;", "[");
                        replace_string(cache, "&#93;", "]");
                        replace_string(cache, "&#44;", ",");
                        replace_string(cache, "&amp;", "&");
                        kv.emplace(key_tmp, cache);
                        cache.clear();
                        key_tmp.clear();
                    }
                }
            } else {
                cache += c;
            }
        }
        else if (c == "]") {
            if (is_start) {
                if (!cache.empty()) {
                    if (!key_tmp.empty()) {
                        replace_string(cache, "&#91;", "[");
                        replace_string(cache, "&#93;", "]");
                        replace_string(cache, "&#44;", ",");
                        replace_string(cache, "&amp;", "&");
                        kv.emplace(key_tmp, cache);
                    } else {
                        kv.emplace("_type", cache);
                    }
                    dest.push_back(kv);
                    kv.clear();
                    key_tmp.clear();
                    cache.clear();
                    is_start = false;
                }
            } else {
                cache += c;
            }
        }
        else {
            cache += c;
            i += (utf8_char_len - 1);
        }
    }
    if (!cache.empty()) {
        std::unordered_map<std::string, std::string> kv;
        replace_string(cache, "&#91;", "[");
        replace_string(cache, "&#93;", "]");
        replace_string(cache, "&amp;", "&");
        kv.emplace("_type", "text");
        kv.emplace("text", cache);
        dest.push_back(kv);
    }
}
