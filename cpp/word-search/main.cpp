/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
    Given board =

    [
    ["ABCE"],
    ["SFCS"],
    ["ADEE"]
    ]
    word = "ABCCED", -> returns true,
    word = "SEE", -> returns true,
    word = "ABCB", -> returns false.
*/

#include <iostream>
#include <string>
#include <vector>
#include <map>
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
    int getNeighbors(vector< vector<int> >& neighbors, vector< vector<char> >& board, vector< vector<bool> >& visited, int m, int n, char obj) {
        int m0 = 0, n0 = 0;
        // check left
        m0 = m, n0 = n-1;
        if (n0 >= 0) {
            if (board[m0][n0] == obj && !visited[m0][n0]) {
                vector<int> pos;
                pos.push_back(m0);
                pos.push_back(n0);
                neighbors.push_back(pos);
            }
        }
        // check right
        m0 = m, n0 = n+1;
        if (n0 < board[0].size()) {
            if (board[m0][n0] == obj && !visited[m0][n0]) {
                vector<int> pos;
                pos.push_back(m0);
                pos.push_back(n0);
                neighbors.push_back(pos);
            }

        }
        // check up
        m0 = m-1, n0 = n;
        if (m0 >= 0) {
            if (board[m0][n0] == obj && !visited[m0][n0]) {
                vector<int> pos;
                pos.push_back(m0);
                pos.push_back(n0);
                neighbors.push_back(pos);
            }

        }
        // check down
        m0 = m+1, n0 = n;
        if (m0 < board.size()) {
            if (board[m0][n0] == obj && !visited[m0][n0]) {
                vector<int> pos;
                pos.push_back(m0);
                pos.push_back(n0);
                neighbors.push_back(pos);
            }

        }
        return neighbors.size();
    }

    bool existSub(vector< vector<char> >& board, vector< vector<bool> >& visited, int m, int n, string word) {
        if (!word.length()) {
            return true;
        }
        vector< vector<int> > positions;
        getNeighbors(positions, board, visited, m, n, word[0]);
        if (!positions.size()) {
            return false;
        }
        int res = false;
        string substr = word.substr(1);
        for (int i = 0; i < positions.size() && !res; i++) {
            int m0 = positions[i][0];
            int n0 = positions[i][1];
            visited[m0][n0] = true;
            res |= existSub(board, visited, m0, n0, substr);
            visited[m0][n0] = false;
        }
        return res;
    }

    bool exist(vector< vector<char> >& board, string word) {
        if (!word.length()) {
            return false;
        }
        if (!board.size() || !board[0].size()) {
            return false;
        }
        if (word.length() > board.size()*board[0].size()) {
            return false;
        }
        vector< vector<bool> > visited(board.size(), vector<bool>(board[0].size(), false));
        bool found = false;
        string substr = word.substr(1);
        for (int m = 0; m < board.size() && !found; m++) {
            for (int n = 0; n < board[0].size() && !found; n++) {
                if (board[m][n] != word[0]) {
                    continue;
                }
                visited[m][n] = true;
                found |= existSub(board, visited, m, n, substr);
                visited[m][n] = false;
            }
        }
        return found;
    }
};

int main() {
    //vector< vector<char> > board(1, vector<char>(2,'a'));
    
    vector< vector<char> > board;
    char arr[3][4] = {{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
    board.push_back(vector<char>(arr[0], arr[0]+sizeof(arr[0])));
    board.push_back(vector<char>(arr[1], arr[1]+sizeof(arr[1])));
    board.push_back(vector<char>(arr[2], arr[2]+sizeof(arr[2])));
    
    for (int i = 0; i < board.size(); i++) 
        display(board[i]);

    Solution s;
    cout<<s.exist(board, "abcced")<<endl;
    cout<<s.exist(board, "see")<<endl;
    cout<<s.exist(board, "abcb")<<endl;
    //cout<<s.exist(board, "aa")<<endl;
    return 0;
}

