/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
*/

#include <iostream>
#include <string>
#include <vector>
#include <set>
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
    bool isValidSudoku(vector< vector<char> >& board) {
        // checking rows
        for (int i = 0; i < 9; i++) {
            set<char> ht;
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ht.find(ch) != ht.end() && ch != '.') {
                    return false;
                }
                ht.insert(ch);
            }
        }

        // checking coloums
        for (int i = 0; i < 9; i++) {
            set<char> ht;
            for (int j = 0; j < 9; j++) {
                char ch = board[j][i];
                if (ht.find(ch) != ht.end() && ch != '.') {
                    return false;
                }
                ht.insert(ch);
            }
        }

        // checking grid
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                set<char> ht;
                for (int r = i*3; r < (i+1)*3; r++) {
                    for (int c = j*3; c < (j+1)*3; c++) {
                        char ch = board[r][c];
                        if (ht.find(ch) != ht.end() && ch != '.') {
                            return false;
                        }
                        ht.insert(ch);
                    }
                }
            }
        }


        return true;
    }
};

int main() {
    Solution s;
    cout<<"Hello World"<<endl;
    return 0;
}

