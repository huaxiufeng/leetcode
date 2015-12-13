/*
   Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

   For example,
   If n = 4 and k = 2, a solution is:

   [
   [2,4],
   [3,4],
   [2,3],
   [1,2],
   [1,3],
   [1,4],
   ]
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
    /*
    vector< vector<int> > comb(int begin, int end, int n) {
        vector< vector<int> > res;
        if (n == 1) {
            for (int i = begin; i <= end; i++) {
                vector<int> item(1, i);
                res.push_back(item);
            }
            return res;
        }
        for (int i = begin; i <= end - n + 1; i++) {
            vector< vector<int> > resi = comb(i+1, end, n-1);
            for (int k = 0; k < resi.size(); k++) {
                resi[k].insert(resi[k].begin(), i);
                res.push_back(resi[k]);
            }
        }
        return res;
    }
    
    vector< vector<int> > combine(int n, int k) {
        return comb(1, n, k);
    }
    */

    void comb(int begin, int end, int k, vector<int>& cur, vector<vector<int>>& res) {
        if (k == 0) {
            res.push_back(cur);
            return;
        }
        if (end < begin) {
            return;
        }
        cur.push_back(begin);
        comb(begin+1, end, k-1, cur, res);
        cur.pop_back();
        comb(begin+1, end, k, cur, res);
    }

    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> res;
        vector<int> cur;
        comb(1, n, k, cur, res);
        return res;
    }
};

int main() {
    Solution s;
    vector<vector<int>> res = s.combine(5,3);
    for (int i = 0; i < res.size(); i++) {
        display(res[i]);
    }
    return 0;
}

