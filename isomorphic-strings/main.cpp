/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
    Given "egg", "add", return true.

    Given "foo", "bar", return false.

    Given "paper", "title", return true.

    Note:
    You may assume both s and t have the same length.
*/

#include <iostream>
#include <string>
#include <cstring>
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

class Solution {
public:
    /*
    bool isIsomorphic(string s, string t) {
        if (s.length()-t.length()) {
            return false;
        }

        map<char, int> sindex, tindex;
        for (int i = 0; i < s.length(); i++) {
            char cs = s[i];
            char ct = t[i];
            bool csfound = sindex.find(cs) != sindex.end();
            bool ctfound = tindex.find(ct) != tindex.end();
            if (csfound != ctfound) {
                return false;
            }
            if (csfound) {
                if (sindex[cs] != tindex[ct]) {
                    return false;
                }
            }
            sindex[cs] = i;
            tindex[ct] = i;
        }

        return true;
    }
    */
    bool isIsomorphic(string s, string t) {
        if (s.length()-t.length()) {
            return false;
        }

        int sindex[128], tindex[128];
        for (int i = 0; i < 128; i++) {
            sindex[i] = -1;
            tindex[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            char& cs = s[i];
            char& ct = t[i];
            bool csfound = (sindex[cs] != 0);
            bool ctfound = (tindex[ct] != 0);
            if (csfound != ctfound) {
                return false;
            }
            if (csfound) {
                if (sindex[cs] != tindex[ct]) {
                    return false;
                }
            }
            sindex[cs] = i;
            tindex[ct] = i;
        }

        return true;
    }
};

int main() {
    Solution s;
    cout<<s.isIsomorphic("ab", "aa")<<endl;
    cout<<s.isIsomorphic("aba", "baa")<<endl;
    cout<<s.isIsomorphic("add", "egg")<<endl;
    cout<<s.isIsomorphic("foo", "bar")<<endl;
    cout<<s.isIsomorphic("paper", "title")<<endl;
    return 0;
}

