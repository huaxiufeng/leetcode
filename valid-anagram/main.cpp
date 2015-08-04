#include <string.h>
#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.length() != t.length()) {
            return false;
        }

        int cnt_table_s[256];
        int cnt_table_t[256];
        memset(cnt_table_s, 0, sizeof(cnt_table_s));
        memset(cnt_table_t, 0, sizeof(cnt_table_t));
        for (int i = 0; i < s.length(); i++) {
            cnt_table_s[s.at(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            cnt_table_t[t.at(i)]++;
        }
        for (int i = 0; i < 256; i++) {
            if (cnt_table_s[i] != cnt_table_t[i]) {
                return false;
            }
        }
        return true;
    }
};

int main() {
    Solution s;
    cout<<s.isAnagram("anagram", "nagaram")<<endl;
    cout<<s.isAnagram("rat", "car")<<endl;
    cout<<"Hello World"<<endl;
    return 0;
}

