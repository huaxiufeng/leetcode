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
    int calc(int a, int b, char op) {
        int res = 0;
        switch (op) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                res = a / b;
                break;
        }
        return res;
    }

    int calculate(string s) {
        vector<char> ops;
        vector<int> nums;

        bool need_calc = false;
        string curnum;
        for (int i = 0; i < s.length();i++) {
            char c = s[i];
             
            if (c <= '9' && c >= '0') {
                curnum += c;
            }
            if (c > '9' || c < '0' || i == s.length()-1) {
                if (curnum.length()) {
                    int num = atoi(curnum.c_str());
                    if (!need_calc) {
                        nums.push_back(num);
                    } else {
                        // calc the high priority
                        int num_size = nums.size();
                        int op_size = ops.size();
                        int num0 = nums[num_size-1];
                        char op = ops[op_size-1];
                        nums.erase(nums.end()-1);
                        ops.erase(ops.end()-1);
                        int res = calc(num0, num, op);
                        nums.push_back(res);
                        need_calc = false;
                    }
                }
                curnum = "";
                if (c == '-' || c == '+') {
                    ops.push_back(s[i]);
                }
                if (c == '*' || c == '/') {
                    ops.push_back(s[i]);
                    need_calc = true;
                }
            }
        }

        int n = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            char c = ops[i-1];
            int m = nums[i];
            if (c == '-') {
                n = n - m;
            }
            if (c == '+') {
                n = n + m;
            }
        }

        return n;
    }
};

int main() {
    string expr = " 3 + 2   * 2     ";
    //string expr = "3/2";
    //string expr = " 3+5 / 2 ";
    Solution s;
    cout<<expr<<" = "<<s.calculate(expr)<<endl;
    return 0;
}

