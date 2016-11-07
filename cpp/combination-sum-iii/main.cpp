/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/

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

class Solution {
public:
    void comb(vector< vector<int> > &res, vector<int> item, int k, int start, int sum) {
        if (k == 1) {
            if (sum >= start && sum <= 9) {
                item.push_back(sum);
                res.push_back(item);
            }
        } else {
            for (int i = start; i <= sum && i <= 9; i++) {
                item.push_back(i);
                comb(res, item, k-1, i+1, sum-i);
                item.erase(item.end()-1);
            }
        }
    }

    vector< vector<int> > combinationSum3(int k, int n) {
        vector< vector<int> > res;
        vector<int> item;
        comb(res, item, k, 1, n);
        return res;
    }
};

int main() {
    vector< vector<int> > res;
    Solution s;
    res = s.combinationSum3(3, 9);
    for (int i = 0; i < res.size(); i++) {
        display(res[i]);
    }
    return 0;
}

