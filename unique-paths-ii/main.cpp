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
    
    int uniquePathsWithObstacles(vector< vector<int> >& obstacleGrid) {
        int m = obstacleGrid.size();
        if (!m) {
            return 0;
        }
        int n = obstacleGrid[0].size();
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1-obstacleGrid[0][0];
        }

        vector<int> line(n, 1);
        vector< vector<int> > grid(m, line);
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                continue;
            }
            while (i < m) {
                grid[i][0] = 0;
                i++;
            }
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                continue;
            }
            while (j < n) {
                grid[0][j] = 0;
                j++;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j]) {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
            }
        }

        return grid[m-1][n-1];
    }
};

int main() {
    Solution s;
    return 0;
}

