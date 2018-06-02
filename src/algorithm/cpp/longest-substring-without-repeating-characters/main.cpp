/*
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/
#include <string.h>
#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    /*
    int lengthOfLongestSubstring(string s) {
        int longest_sub = 0;
        for (int i = 0; i < s.length(); i++) {
            bool set[256];
            memset(set, 0, sizeof(set));
            int sub = 0;
            for (int j = i; j < s.length(); j++) {
                if (set[s.at(j)] == true) {
                    sub = j - i;
                    break;
                }
                set[s.at(j)] = true;
            }
            if (sub == 0) {
                sub = s.length() - i;
            }
            if (sub > longest_sub) {
                longest_sub = sub;
            }
        }
        return longest_sub;
    }
    */

/*
index 0  1  2  3  4  5  6  7  8
str   a  b  c  a  b  c  b  b  0
next  3  4  5  8  6  8  7  8  
first 3  4  5  6  6  7  7  8

0  1  2  3
a  b  b  a
3  2  4  4
2  2  4  4
*/
    int lengthOfLongestSubstring(string s) {
        int longest_sub = 0;
        const char *str = s.c_str();
        int len = s.length();
        int indextable[256];
        memset(indextable, 0, sizeof(indextable));
        int *next = new int[len];
        int *first = new int[len];
        indextable[str[len-1]] = len-1; // 字符出现的位置
        next[len-1] = len; // 该位置的字符下一次出现的位置
        first[len-1] = len; // 从该位置开始，下一个开始出现重复字符的位置
        for (int i = len-2; i >= 0; i--) {
            if (indextable[str[i]] != 0) {
                next[i] = indextable[str[i]];
            } else {
                next[i] = len;
            } 
            indextable[str[i]] = i;
            if (next[i] != len && next[i] < first[i+1]) {
                first[i] = next[i];
            } else {
                first[i] = first[i+1];
            }
        }
        for (int i = 0; i < len; i++) {
            if (first[i] - i > longest_sub) {
                longest_sub = first[i] - i;
            }
        }
        delete []next;
        delete []first;
        return longest_sub;
    }

};

int main() {
    cout<<"Hello World"<<endl;
    Solution s;
    cout<<s.lengthOfLongestSubstring("abba")<<endl;
    cout<<s.lengthOfLongestSubstring("bbbbb")<<endl;
    cout<<s.lengthOfLongestSubstring("abcabcbb")<<endl;
    return 0;
}

