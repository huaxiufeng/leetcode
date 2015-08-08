/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/

#include <cstring>
#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    int strStr(char* haystack, char* needle) {
        if (!haystack || !needle) return -1;
        if (strlen(haystack) < strlen(needle)) return -1;
        for (int i = 0; i < strlen(haystack)-strlen(needle)+1; i++) {
            bool match = true;
            for (int j = 0; j < strlen(needle); j++) {
                if (haystack[i+j] != needle[j]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return i;
            }
        }
        return -1;
    }
};

int main() {
    Solution s;
    cout<<s.strStr(0,"hua")<<endl;
    cout<<s.strStr("xiufenghua","hua")<<endl;
    cout<<s.strStr("huiyewang","hua")<<endl;
    cout<<s.strStr("hua","hua")<<endl;
    return 0;
}

