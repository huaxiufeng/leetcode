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

template <typename T>
void display(vector<vector<T>>& array) {
    for (int i = 0; i < array.size(); i++) {
        display(array[i]);
    }
}

class Solution {
public:
    void scan(const string& s, vector<vector<bool>>& pdtable) {
        int sz = s.length();
        for (int i = sz-1; i >= 0; i--) {
            for (int j = i; j < sz; j++) {
                if (j == i) {
                    pdtable[i][i] = true;
                    continue;
                }
                if (j == i+1) {
                    if (s[j] == s[i]) {
                        pdtable[i][j] = true;
                    }
                } else {
                    if (s[j] == s[i] && pdtable[i+1][j-1]) {
                        pdtable[i][j] = true;
                    }
                }
            }
        }
    }

    void find_partitions(const string& s, const vector<vector<bool>>& pdtable, int begin, vector<string>& curset, vector<vector<string>>& result) {
        if (begin == s.length()) {
            result.push_back(curset);
            return;
        }

        for (int i = begin; i < s.length(); i++) {
            if (pdtable[begin][i]) {
                curset.push_back(s.substr(begin, i-begin+1));
                find_partitions(s, pdtable, i+1, curset, result);
                curset.pop_back();
            }
        }
    }

    vector<vector<string>> partition(string s) {
        vector<vector<string>> result;
        int sz = s.length();
        if (sz == 0) {
            return result;
        }
        // pdtable[i][j] = true, means s[i-j] is palindrome
        vector<vector<bool>> pdtable(sz, vector<bool>(sz, false));
        scan(s, pdtable);
        display(pdtable);
        vector<string> curset;
        find_partitions(s, pdtable, 0, curset, result);
        display(result);
        return result;
    }
};

int main() {
    Solution s;
    s.partition("abbab");
    return 0;
}

