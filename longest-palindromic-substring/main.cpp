/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/
#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    /*
    // brute force
    bool isPalindrome(string s) {
        if (!s.length()) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }

        int idx1 = s.length() / 2;
        int idx0 = idx1;
        if (s.length() % 2 == 0) {
            idx0--;
        }
        while (idx0 >= 0) {
            if (s.at(idx0) != s.at(idx1)) {
                return false;
            }
            idx0--;
            idx1++;
        }
        return true;
    }

    string longestPalindrome(string s) {
        string res;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j <= s.length()-i; j++) {
                string sub = s.substr(i, j);
                if (isPalindrome(sub) && j > res.length()) {
                    res = sub;
                }
            }
        }
        return res;
    }
    */

    string expandCenter(string s, int idx0, int idx1) {
        string res;
        while (idx0 >= 0 and idx1 <= s.length()-1) {
            if (s.at(idx0) != s.at(idx1)) {
                break;
            }
            res = s.substr(idx0, idx1-idx0+1);
            idx0--;
            idx1++;
        }
        return res;
    }

    string longestPalindrome(string s) {
        if (s.length() <= 1) {
            return s;
        }

        string res;
        for (int i = 1; i < s.length(); i++) {
            string sub0 = expandCenter(s, i, i);
            string sub1 = expandCenter(s, i-1, i);
            string sub = sub0.length() > sub1.length() ? sub0 : sub1;
            if (sub.length() > res.length()) {
                res = sub;
            }
            if (res.length() == s.length()) {
                break;
            }
        }
        return res;
    }
};

int main() {
    Solution s;
    cout<<s.longestPalindrome("xxhuauhyy")<<endl;
    cout<<s.longestPalindrome("xxhuaauhyy")<<endl;
    cout<<s.longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")<<endl;
    cout<<"Hello World"<<endl;
    return 0;
}

