#ifndef UNTITLED_CQCODE_H
#define UNTITLED_CQCODE_H

#include <string>
#include <unordered_map>
#include <vector>
#include <exception>

class illegal_code: std::exception {
public:
    [[nodiscard]] const char * what() const noexcept override {
        return "Error cq code.";
    }
};

void decode_cqcode(const std::string& code, std::vector<std::unordered_map<std::string, std::string>>& dest);

void encode_cqcode(const std::vector<std::unordered_map<std::string, std::string>>& segment, std::string& dest);

#endif //UNTITLED_CQCODE_H
