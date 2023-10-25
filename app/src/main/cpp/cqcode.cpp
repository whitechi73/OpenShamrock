#include <stdexcept>
#include "cqcode.h"

inline void replace_string(std::string& str, const std::string& from, const std::string& to) {
    size_t startPos = 0;
    while ((startPos = str.find(from, startPos)) != std::string::npos) {
        str.replace(startPos, from.length(), to);
        startPos += to.length();
    }
}

void decode_cqcode(const std::string& code, std::vector<std::unordered_map<std::string, std::string>>& dest) {
    std::string cache;
    bool is_start = false;
    std::string key_tmp;
    std::unordered_map<std::string, std::string> kv;
    for(int i = 0; i < code.size(); i++) {
        auto c = code[i];
        if (c == '[') {
            if (is_start) {
                throw illegal_code();
            } else {
                if (!cache.empty()) {
                    std::unordered_map<std::string, std::string> kv;
                    kv.emplace("_type", "text");
                    kv.emplace("text", cache);
                    dest.push_back(kv);
                    cache.clear();
                }
                auto c1 = code[i + 1];
                if (c1 == 'C') {
                    i++;
                    auto c2 = code[i + 1];
                    if(c2 == 'Q') {
                        i++;
                        auto c3 = code[i + 1];
                        if (c3 == ':') {
                            i++;
                            is_start = true;
                        } else {
                            cache += c;
                            cache += c1;
                            cache += c2;
                            continue;
                        }
                    } else {
                        cache += c;
                        cache += c1;
                        continue;
                    }
                } else {
                    cache += c;
                    continue;
                }
            }
        }
        else if (c == '=') {
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
        else if (c == ',') {
            if (is_start) {
                if (kv.count("_type") == 0 && !cache.empty()) {
                    kv.emplace("_type", cache);
                    cache.clear();
                } else {
                    if (!key_tmp.empty()) {
                        replace_string(cache, "&amp;", "&");
                        replace_string(cache, "&#91;", "[");
                        replace_string(cache, "&#93;", "]");
                        replace_string(cache, "&#44;", ",");
                        kv.emplace(key_tmp, cache);
                        cache.clear();
                        key_tmp.clear();
                    }
                }
            } else {
                cache += c;
            }
        }
        else if (c == ']') {
            if (is_start) {
                if (!cache.empty()) {
                    if (!key_tmp.empty()) {
                        replace_string(cache, "&amp;", "&");
                        replace_string(cache, "&#91;", "[");
                        replace_string(cache, "&#93;", "]");
                        replace_string(cache, "&#44;", ",");
                        kv.emplace(key_tmp, cache);
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
        }
    }
    if (!cache.empty()) {
        std::unordered_map<std::string, std::string> kv;
        kv.emplace("_type", "text");
        kv.emplace("text", cache);
        dest.push_back(kv);
    }
}
