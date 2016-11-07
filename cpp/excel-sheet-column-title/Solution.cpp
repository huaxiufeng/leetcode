/*
Given a non-zero positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

1 -> A
2 -> B
3 -> C
...
26 -> Z
27 -> AA
28 -> AB 
*/

class Solution
{
public:
    string convertToTitle(int n) {
        string result;
        if (n <= 0) {
            return result;
        }

        do {
            char c = 'A' + (n-1) % 26;
            result = c + result;
            n = (n-1) / 26;
        } while (n);

        return result; 
    }
};
