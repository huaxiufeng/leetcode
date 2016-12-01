#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

template <typename T>
void display(vector<T>& array) {
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
    int maximalSquare(vector<vector<char>>& matrix) {
        if (matrix.size() == 0 || matrix[0].size() == 0) {
            return 0;
        }
        int maxsquare = 0;
        vector<vector<char>> square = matrix;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix[i].size(); j++) {
                square[i][j] = matrix[i][j] - '0';
                if (square[i][j]) {
                    maxsquare = 1;
                }
            }
        }
        
        for (int i = 1; i < matrix.size(); i++) {
            for (int j = 1; j < matrix[i].size(); j++) {
                if (matrix[i][j] == '0') {
                    square[i][j] = 0;
                } else {
                    int lastsquare = square[i-1][j-1];
                    square[i][j] = 1;
                    for (int k = 0; k < lastsquare; k++) {
                        if (matrix[i-k-1][j] == '1' && matrix[i][j-k-1] == '1') {
                            square[i][j]++;
                        } else {
                            break;
                        }
                    }
                }
                int sq2 = square[i][j] * square[i][j];
                if (sq2 > maxsquare) {
                    maxsquare = sq2;
                }
            }
        }
        return maxsquare;
    }
};

int main() {
    vector<vector<char>> matrix;
    /*
    vector<char> line(4,'0');
    line[2] = '1';
    matrix.push_back(line);
    line[0] = '1', line[1] = '1', line[2] = '1', line[3] = '1';
    matrix.push_back(line);
    matrix.push_back(line);
    line[3] = '0';
    matrix.push_back(line);
    line[2] = '0';
    matrix.push_back(line);
    line[2] = '1', line[3] = '1';
    matrix.push_back(line);
    line[3] = '0';
    matrix.push_back(line);
    */
    /* 
    vector<char> line(5,'0');
    line[4] = '1';
    matrix.push_back(line);
    line[0] = '1', line[1] = '1', line[2] = '1', line[4] = '0';
    matrix.push_back(line);
    matrix.push_back(line);
    matrix.push_back(line);
    line[0] = '0', line[4] = '1';
    matrix.push_back(line);
    */
    /*
    vector<char> line(2,'0');
    matrix.push_back(line);
    matrix.push_back(line);
    */
     
    vector<char> line(2,'1');
    line[0] = '0';
    matrix.push_back(line);
    

    display(matrix);

    Solution s;
    cout<<s.maximalSquare(matrix)<<endl;
    return 0;
}

