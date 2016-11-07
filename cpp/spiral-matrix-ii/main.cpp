/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
    Given n = 3,

    You should return the following matrix:
    [
    [ 1, 2, 3 ],
    [ 8, 9, 4 ],
    [ 7, 6, 5 ]
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
        cout<<array[i]<<"\t";
    }
    cout<<endl;
}

class Solution {
public:
    vector< vector<int> > generateMatrix(int n) {
        vector<int> line(n,0);
        vector< vector<int> > res(n,line);

        int begin = 0, end = n-1;
        int value = 1;
        while (begin <= end) {
            int x = begin, y = begin;
            if (begin == end) {
                res[x][y] = value++;
                break;
            }
            while (y < end) {
                res[x][y++] = value++;
            }
            while (x < end) {
                res[x++][y] = value++;
            }
            while (y > begin) {
                res[x][y--] = value++;
            }
            while (x > begin) {
                res[x--][y] = value++;
            }
            begin++;
            end--;
        }

        return res;
    }
};

int main() {
    Solution s;
    vector< vector<int> > res = s.generateMatrix(6);
    for (int i = 0; i < res.size(); i++) {
        display(res[i]);
    }
    return 0;
}

