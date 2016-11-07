/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/

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
