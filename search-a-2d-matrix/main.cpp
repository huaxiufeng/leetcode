/*
   Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

   Integers in each row are sorted from left to right.
   The first integer of each row is greater than the last integer of the previous row.
   For example,

   Consider the following matrix:

   [
   [1,   3,  5,  7],
   [10, 11, 16, 20],
   [23, 30, 34, 50]
   ]
   Given target = 3, return true.
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
    bool searchMatrix(vector< vector<int> >& matrix, int target) {
        int h = matrix.size();
        if (!h) {
            return false;
        }
        int w = matrix[0].size();
        if (!w) {
            return false;
        }
        if (target < matrix[0][0]) {
            return false;
        }
        if (target > matrix[h-1][w-1]) {
            return false;
        }
        
        int b = 0, e = h -1;
        while (b <= e) {
            int m = (b+e)/2;
            int v = matrix[m][0];
            if (v < target) {
                if (m + 1 > h - 1) {
                    break;
                }
                b = m + 1;
            } else if (v > target) {
                if (m - 1 < 0) {
                    break;
                }
                e = m - 1;
            } else {
                return true;
            }
        }
        
        b = b > e ? e : b;

        int l = 0, r = w - 1;
        while (l <= r) {
            int m = (l+r)/2;
            int v = matrix[b][m];
            if (v < target) {
                l = m + 1;
            } else if (v > target) {
                r = m - 1;
            } else {
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

