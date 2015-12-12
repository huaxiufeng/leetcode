#include <iostream>
#include <sstream>
#include <string>
#include <vector>
#include <map>
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
    bool wordPattern(string pattern, string str) {
        istringstream iss(str);
        string word;
        int index = 0;
        map<char, string> table;
        map<string, char> rtable;
        while (iss>>word) {
            if (index >= pattern.length()) {
                return false;
            }
            char c = pattern[index];
            if (table.find(c) == table.end()) {
                if (rtable.find(word) != rtable.end()) {
                    return false;
                }
                table[c] = word;
                rtable[word] = c;
            } else {
                if (rtable.find(word) == rtable.end()) {
                    return false;
                }
                if (rtable[word] != c) {
                    return false;
                }
                if (table[c] != word) {
                    return false;
                }
            }
            index++;
        }
        if (index != pattern.length()) {
            return false;
        }
        return true;
    }
};

int main() {
    Solution s;
    cout<<s.wordPattern("", "")<<endl;
    cout<<s.wordPattern("abba", "dog cat cat dog")<<endl;
    cout<<s.wordPattern("abab", "dog dog dog dog")<<endl;
    return 0;
}

