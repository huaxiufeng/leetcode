/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

template <typename T>
void display(vector<T> array) {
    for (int i = 0; i < array.size(); i++) {
        cout<<array[i]<<" ";
    }
    cout<<endl;
}

class Solution {
public:
/*
    int numDecodings0(int b, string& s) {
        int i = b;
        for (; i < s.length(); i++) {
            if (s[i] <= '2') break;
        }
        if (i == s.length()) {
            return 1;
        }
        b = i;

        if (s.length() - b <= 1) {
            return 1;
        } else {
            int res = 0;
            char c0 = s[b+0];
            char c1 = s[b+1];
            int val = (c0-'0')*10 + (c1-'0');
            if (val >= 1 && val <= 26) {
                res += numDecodings0(b+2, s);
            }
            if (c1 != '0') {
                res += numDecodings0(b+1, s);
            }
            return res;
        }
    }

    int numDecodings(string s) {
        return numDecodings0(0, s);
    }
*/
    int numDecodings(string s) {
        if (!s.length()) {
            return 0;
        }
        if (s[0]=='0') {
            return 0;
        }

        vector<int> count(s.length()+1, 0);
        count[0] = 1;
        count[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s[i] != '0') {
                count[i+1] = count[i];
            }

            if (s[i-1] != '0') {
                int val = (s[i-1]-'0')*10+(s[i]-'0');
                if (val >= 1 && val <= 26) {
                    count[i+1] += count[i-1];
                }
            }
        }
        return count[s.length()];
    }
};

int main() {
    Solution s;
    //string str = "9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253";
    string str = "101";
    cout<<s.numDecodings(str)<<endl;
    return 0;
}

