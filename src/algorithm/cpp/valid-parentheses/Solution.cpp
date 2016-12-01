#include <stack>

class Solution
{
public:
    bool isValid(string s) {
        std::stack<char> stk;
        for (size_t i = 0; i < s.length(); i++) {
            if (isLeft(s[i])) {
                stk.push(s[i]);
            } else
                if (isRight(s[i])) {
                    if (!stk.size()) {
                        return false;
                    }
                    char c = stk.top();
                    stk.pop();
                    if (!isPair(c, s[i])) {
                        return false;
                    }
                } else {
                    return false;
                }
        }
        return !stk.size();
    }

    bool isLeft(const char c) {
        if ('(' == c || '[' == c || '{' == c) {
            return true;
        }
        return false;
    }
    bool isRight(const char c) {
        if (')' == c || ']' == c || '}' == c) {
            return true;
        }
        return false;
    }
    bool isPair(const char c1, const char c2) {
        bool res = false;
        if ('(' == c1 && ')' == c2) {
            res = true;
        } else
            if ('[' == c1 && ']' == c2) {
                res = true;
            } else
                if ('{' == c1 && '}' == c2) {
                    res = true;
                }
        return res;
    }
};
