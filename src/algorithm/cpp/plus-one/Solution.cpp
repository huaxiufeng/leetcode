/*
Given a non-negative number represented as an array of digits, plus one to the number.
The digits are stored such that the most significant digit is at the head of the list.
   */

class Solution
{
public:
    vector<int> plusOne(vector<int> &digits) {
        vector<int> result;
        if (0 == digits.size()) {
            result.push_back(1);
            return result;
        }
        int extra = 0;
        for (int i = digits.size() - 1; i >= 0; i--) {
            int v = digits[i];
            if (i == digits.size() - 1) {
                v += 1;
            } else {
                v += extra;
            }
            if (v > 9) {
                extra = 1;
                v = v % 10;
            } else {
                extra = 0;
            }
            result.push_back(v);
        }
        if (extra) {
            result.push_back(extra);
        }

        for (int i = 0; i < result.size(); i++) {
            int j = result.size() - i - 1;
            if (j <= i) break;
            int v = result[i];
            result[i] = result[j];
            result[j] = v;
        }

        return result;
    }
};
