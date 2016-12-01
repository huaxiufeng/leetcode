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
    void rotate(vector <vector<int> >& matrix) {
        int n = matrix.size();
        int total = n*n;
        int loop_count = total / 4;
        int x = 0, y = -1;
        for (int i = 0; i < loop_count; i++) {
            y++;
            if (y >= n-x-1) {
                x++;
                y = x;
            }
            int temp0 = matrix[x][y];
            for (int k = 0; k < 4; k++) {
                int nx = y, ny = n-1-x;
                int temp1 = matrix[nx][ny];
                matrix[nx][ny] = temp0;
                x = nx;
                y = ny;
                temp0 = temp1;
            }
        }
    }
};

int main() {
    int n = 10;
    vector< vector<int> > m;
    for (int i = 0; i < n; i++) {
        vector<int> v;
        for (int j = 0; j < n; j++) {
            v.push_back(n*i+j+1);
        }
        m.push_back(v);
    }

    
    Solution s;

    for (int i = 0; i < n; i++) {
        display(m[i]);
    }

    s.rotate(m);

    cout<<endl<<">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"<<endl<<endl;

    for (int i = 0; i < n; i++) {
        display(m[i]);
    }

    return 0;
}

