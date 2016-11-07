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
    void setZeroes(vector< vector<int> >& matrix) {
        bool first_row_has_0 = false;
        bool first_col_has_0 = false;
        
        for (int i = 0; i < matrix.size(); i++) {
            if (!matrix[i][0]) {
                first_col_has_0 = true;
                break;
            }
        }
        for (int j = 0; j < matrix[0].size(); j++) {
            if (!matrix[0][j]) {
                first_row_has_0 = true;
                break;
            }
        }


        for (int i = 1; i < matrix.size(); i++) {
            for (int j = 1; j < matrix[i].size(); j++) {
                if (!matrix[i][j]) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.size(); i++) {
            for (int j = 1; j < matrix[i].size(); j++) {
                if (!matrix[i][0] || !matrix[0][j]) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix.size() && first_col_has_0; i++) {
            matrix[i][0] = 0;
        }
        for (int j = 0; j < matrix[0].size() && first_row_has_0; j++) {
            matrix[0][j] = 0;
        }
    }
};

int main() {
    Solution s;
    cout<<"Hello World"<<endl;
    return 0;
}

