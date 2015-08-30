/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

    Consider the following matrix:

    [
    [1,   4,  7, 11, 15],
    [2,   5,  8, 12, 19],
    [3,   6,  9, 16, 22],
    [10, 13, 14, 17, 24],
    [18, 21, 23, 26, 30]
    ]
    Given target = 5, return true.

    Given target = 20, return false.
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
    bool found(vector<int>& l, int b, int e, int target) {
        while (b <= e) {
            int m = (b+e)/2;
            int v = l[m];
            if (v < target) {
                b = m + 1;
            } else if (v > target) {
                e = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    bool searchMatrix(vector< vector<int> >& matrix, int target) {
        int h = matrix.size();
        if (!h) {
            return false;
        }
        int w = matrix[0].size();
        if (!w) {
            return false;
        }

        int rb = -1, re = -1;
        int cb = -1, ce = -1;

        for (int i = 0; i < h; i++) {
            if (matrix[i][0] <= target && matrix[i][w-1] >= target) {
                if (rb == -1) {
                    rb = i;
                }
                re = i;
            }
        }
        
        for (int i = 0; i < w; i++) {
            if (matrix[0][i] <= target && matrix[h-1][i] >= target) {
                if (cb == -1) {
                    cb = i;
                }
                ce = i;
            }
        }

        if (rb == -1 || re == -1 || cb == -1 || ce == -1) {
            return false;
        }

        for (int i = rb; i <= re; i++) {
            if (found(matrix[i], cb, ce, target)) {
                return true;
            }
        }

        return false;
    }
};

int main() {
    Solution s;
    cout<<"Hello World"<<endl;
    return 0;
}

