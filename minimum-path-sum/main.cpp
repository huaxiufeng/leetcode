/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
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
    int min(int a, int b) {
        return a<b?a:b;
    }

    int minPathSum(vector<vector<int> >& grid) {
        int h = grid.size();
        if (!h) {
            return 0;
        }
        int w = grid[0].size();
        if (!w) {
            return 0;
        }
        vector<int> line(w,0);
        vector< vector<int> > pathsum(h, line);
        
        pathsum[0][0] = grid[0][0];
        for (int i = 1; i < h; i++) {
            pathsum[i][0] = grid[i][0] + pathsum[i-1][0];
        }
        for (int j = 1; j < w; j++) {
            pathsum[0][j] = grid[0][j] + pathsum[0][j-1];
        }
        cout<<"------"<<endl;
        for (int i = 0; i < pathsum.size(); i++) {
            display(pathsum[i]);
        }
        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                pathsum[i][j] = grid[i][j] + min(pathsum[i-1][j], pathsum[i][j-1]);
            }
        }
        
        cout<<"------"<<endl;
        for (int i = 0; i < pathsum.size(); i++) {
            display(pathsum[i]);
        }

        return pathsum[h-1][w-1];
    }
};

int main() {
    Solution s;
    vector<int> line1;
    vector<int> line2;

    line1.push_back(1);
    line1.push_back(2);
    line2.push_back(1);
    line2.push_back(1);
   
    vector< vector<int> > grid;
    grid.push_back(line1);
    grid.push_back(line2);

    for (int i = 0; i < grid.size(); i++) {
        display(grid[i]);
    }

    s.minPathSum(grid);

    return 0;
}

