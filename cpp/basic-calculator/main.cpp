/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.
*/

#include <iostream>
#include <cstdio>
#include <string>
#include <vector>
#include <stack>
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
    int calc(vector<char>& op, vector<int>& val) {
        int val_cnt = val.size();
        int n = val[val_cnt - 1];
        for (int i = val_cnt - 2; i >= 0; i--) {
            char c = op[i];
            int m = val[i];
            if (c == '-') {
                n = n - m;
            }
            if (c == '+') {
                n = n + m;
            }
        }
        return n;
    }
    int calculate(string s) {
        stack<char> ops;
        stack<string> nums;

        string curnum;
        for (int i = 0; i < s.length();) {
            char c = s[i];
            
            if (c <= '9' && c >= '0') {
                curnum += c;
            } else {
                if (curnum.length()) {
                    nums.push(curnum);
                }
                curnum = "";
                if (c == '-' || c == '+') {
                    ops.push(s[i]);
                }
                if (c == '(') {
                    nums.push("(");
                }
                if (c == ')') {
                    // do calc
                    vector<int> val;
                    vector<char> op;
                    string str;
                    while (1) {
                        str = nums.top();
                        nums.pop();
                        if (str == "(") {
                            break;
                        }
                        val.push_back(atoi(str.c_str()));
                    }
                    for (int j = 1; j < val.size(); j++) {
                        char ch = ops.top();
                        ops.pop();
                        op.push_back(ch);
                    }
                    int n = calc(op, val);
                    char buf[128];
                    snprintf(buf, sizeof(buf), "%d", n);
                    nums.push(buf);
                }
            }

            i++;
            if (i == s.length() && curnum.length()) {
                nums.push(curnum);
            }
        }

        if (ops.size()) {
            vector<int> val;
            vector<char> op;
            while (nums.size()) {
                string str = nums.top();
                nums.pop();
                val.push_back(atoi(str.c_str()));
            }
            while (ops.size()) {
                char ch = ops.top();
                ops.pop();
                op.push_back(ch);
            }
            return calc(op, val);
        } else {
            return atoi(nums.top().c_str());
        }
    }
};

int main() {
    //string expr = "(1+2)+(3+4)";
    string expr = "(1+(4+5+2)-3)+(6+8)";
    Solution s;
    cout<<expr<<" = "<<s.calculate(expr)<<endl;
    return 0;
}

