/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    /*
    // wrong logic!!!
    vector<string> generateParenthesis(int n) {
        if (n == 1) {
            cout<<"* n is 1, return ()"<<endl;
            return vector<string>(1, string("()"));
        }
        vector<string> res;
        
        vector<string> res0 = generateParenthesis(n-1);
        for (int i = 0; i < res0.size(); i++) {
            res.push_back("("+res0[i]+")");
            res.push_back("()"+res0[i]);
            if (res0[i]+"()" != "()"+res0[i]) {
                res.push_back(res0[i]+"()");
            }
        }
        for (int i = 0; i < res.size(); i++) {
            cout<<"* n is "<<n<<", return \t"<<res[i]<<endl;
        
        }
        return res;
    }
    */

    void generate(int left, int right, string s, vector<string>& result) {
        if (!left && !right) {
            result.push_back(s);
        } else {
            if (left > 0) {
                generate(left-1, right, s+"(", result);
            }
            if (right > 0 && left < right) {
                generate(left, right-1, s+")", result);
            }
        }
    }

    vector<string> generateParenthesis(int n) {
        vector<string> res;
        generate(n, n, "", res);
        return res;
    }
};

int main() {
    Solution s;
    vector<string> res = s.generateParenthesis(4);
    for (int i = 0; i < res.size(); i++) {
        cout<<i+1<<"\t"<<res[i]<<endl;
    }
    return 0;
}

