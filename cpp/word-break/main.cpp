#include <iostream>
#include <string>
#include <vector>
#include <set>
#include <unordered_set>
#include <algorithm>
using namespace std;

template <typename T>
void display(vector<T> array) {
    for (int i = 0; i < array.size(); i++) {
        cout<<array[i]<<" ";
    }
    cout<<endl;
}

template <typename T>
void display(vector<vector<T>>& array) {
    for (int i = 0; i < array.size(); i++) {
        display(array[i]);
    }
}

class Solution {
public:
    bool wordBreak(string s, unordered_set<string>& wordDict) {
        int minlen = 0, maxlen = 0;
        for (auto itor = wordDict.begin(); itor != wordDict.end(); itor++) {
            if (minlen == 0) {
                minlen = itor->length();
            }
            if (minlen > itor->length()) {
                minlen = itor->length();
            }
            if (maxlen < itor->length()) {
                maxlen = itor->length();
            }
        }
        if (!minlen || !maxlen) {
            return false;
        }

        vector<bool> breakflag(s.length(), false);
        for (int i = 0; i < s.length(); i++) {
            for (int k = minlen; k <= maxlen; k++) {
                int idx = i - k + 1;
                if (idx < 0) continue;
                if (idx == 0 || breakflag[idx-1]) {
                    if (wordDict.find(s.substr(idx,k)) != wordDict.end()) {
                        breakflag[i] = true;
                    }
                }
            }
        }

        return breakflag[s.length()-1];
    }
};

int main() {
    unordered_set<string> wordDict;
    
    string s = "leetcode";
    wordDict.insert("leet");
    wordDict.insert("code");

/*
    string s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";    
    wordDict.insert("a");
    wordDict.insert("aa");
    wordDict.insert("aaa");
    wordDict.insert("aaaa");
    wordDict.insert("aaaaa");
    wordDict.insert("aaaaaa");
    wordDict.insert("aaaaaaa");
    wordDict.insert("aaaaaaaa");
    wordDict.insert("aaaaaaaaa");
    wordDict.insert("aaaaaaaaaa");
*/
    Solution sl;
    cout<<sl.wordBreak(s, wordDict)<<endl;
    return 0;
}

