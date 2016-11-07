class Solution
{
public:
    string countAndSay(int n) {
        if (1 == n) {
            return "1";
        } else {
          return next(countAndSay(n-1));
        }
    }
private:
    string next(string s) {
        if (!s.length()) {
            return s;
        }
        string result;
        char c = s.at(0);
        char count_str[256];
        int count = 0;
        for (size_t i = 0; i < s.length(); i++) {
            if (count == 0) {
                c = s.at(i);
                count++;
            } else {
                if (c == s.at(i)) {
                    count++;
                } else {
                    snprintf(count_str, sizeof(count_str), "%d", count);
                    result += count_str;
                    result += c;
                    c = s.at(i);
                    count = 1;
                }
            }
        }
        if (count > 0) {
            snprintf(count_str, sizeof(count_str), "%d", count);
            result += count_str;
            result += c;
        }
        return result;
    }
};
