/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    string getDigitLetter(int n) {
        switch (n) {
        case 2:
            return "abc";
        case 3:
            return "def";
        case 4:
            return "ghi";
        case 5:
            return "jkl";
        case 6:
            return "mno";
        case 7:
            return "pqrs";
        case 8:
            return "tuv";
        case 9:
            return "wxyz";
        default:
            return "";
        }
    }

    vector<string> appendCombination(vector<string> combined, string digits) {
        if (!digits.length()) {
            return combined;
        }
        char c = digits.at(0);
        string letters = getDigitLetter(c-'1'+1);
        if (!letters.length()) {
            return appendCombination(combined, digits.substr(1));
        }
        vector<string> combined1;
        for (int i = 0; i < combined.size(); i++) {
            string s = combined[i];
            for (int j = 0; j < letters.size(); j++) {
                combined1.push_back(s+letters.at(j));
            }
        }
        return appendCombination(combined1, digits.substr(1));
    }

    vector<string> letterCombinations(string digits) {
        vector<string> res;
        if (!digits.size()) {
            return res;
        }
        res.push_back("");
        return appendCombination(res, digits);
    }
};

int main() {
    Solution s;
    vector<string>res = s.letterCombinations("1234");
    
    for (int i = 0; i < res.size(); i++) {
        cout<<res[i]<<endl;
    }

    return 0;
}

