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
    // m height
    // n width
    // x 
    // y
    int pathCount(int y, int x, int m, int n) {
        if (m <= 0 || n <= 0) return 0;

        if (x == n) {
            return 1;
        } else if (y == m) {
            return 1;
        } else {
            return pathCount(y+1, x, m, n) +
                pathCount(y, x+1, m, n);
        }
    }

    int uniquePaths(int m, int n) {
        return pathCount(1,1,m,n);
    }
    */
    
    int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 1) {
            return 1;
        }

        vector<int> line(n, 1);
        vector< vector<int> > grid(m, line);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }

        return grid[m-1][n-1];
    }
};

int main() {
    Solution s;
    cout<<s.uniquePaths(23,12)<<endl;
    return 0;
}

