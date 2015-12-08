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
    bool isOp(char c) {
        if (c == '+' || c == '-' || c =='*') {
            return true;
        }
        return false;
    }
    int calc(int a, int b, char op) {
        switch(op) {
        case '+':
            return a+b;
        case '-':
            return a-b;
        case '*':
            return a*b;
        }
        return 0;
    }
    vector<int> diffWaysToCompute(string input) {
        vector<int> res;
        if (!input.length()) {
            return res;
        }
        char op = 0;
        for (int i = 0; i < input.length(); i++) {
            if (!isOp(input[i])) continue;
            op = input[i];
            vector<int> left = diffWaysToCompute(input.substr(0, i));
            vector<int> right = diffWaysToCompute(input.substr(i+1));
            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    res.push_back(calc(left[j], right[k], op));
                }
            }
        }
        if (!op) {
            res.push_back(atoi(input.c_str()));
        }
        return res;
    }
};

int main() {
    Solution s;
    vector<int> res = s.diffWaysToCompute("2*3-4*5");
    display(res);
    return 0;
}

