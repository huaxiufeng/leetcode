class Solution
{
public:
    int atoi(const char *str) {
        if (!str) {
            return 0;
        }
        int result = 0;
        bool is_neg = false;
        const char *p = str;
        while (*p == ' ') {
            p++;
        }
        if (*p == '-') {
            is_neg = true;
            p++;
        }
        else
        if (*p == '+') {
            p++;
        }
        int max_int = 0X7FFFFFFF;
        while (*p) {
            if (*p < '0' || *p > '9') {
                break;
            }
            int new_result = result*10 + *p - '0';
            if (new_result < result ||
                (new_result-*p+'0')%10) 
            {
                if (!is_neg)
                    result = max_int;
                if (is_neg)
                    result = max_int + 1;
                break;
            }
            result = new_result;
            p++;
        }
        if (is_neg) {
            result = result * (-1);
        }
        return result;
    }
};
