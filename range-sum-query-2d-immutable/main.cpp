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

};

class NumMatrix {
public:
    NumMatrix(vector<vector<int>> &matrix) {
        if (matrix.size() == 0) {
            return;
        }
        if (matrix[0].size() == 0) {
            return;
        }
        table.reserve(matrix.size()+1);
        vector<int> line(matrix[0].size()+1, 0);
        table.insert(table.begin(), matrix.size()+1, line);
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix[0].size(); j++) {
                table[i+1][j+1] = table[i+1][j] + table[i][j+1] - table[i][j] + matrix[i][j];
            }
        }
    }

    int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 < 0 || col1 < 0 || row2+1 >= table.size() || col2+1 >= table[0].size()) {
            return 0;
        }
        return table[row2+1][col2+1] + table[row1][col1] - table[row1][col2+1] - table[row2+1][col1];
    }

    vector<vector<int>> table;
};

int main() {
    vector<vector<int>> m(5, vector<int>(5,1));
    NumMatrix nm(m);
    
    cout<<nm.sumRegion(0,0,0,0)<<endl;
    cout<<nm.sumRegion(0,0,1,1)<<endl;
    cout<<nm.sumRegion(0,0,2,2)<<endl;
    cout<<nm.sumRegion(0,0,5,5)<<endl;
    return 0;
}

