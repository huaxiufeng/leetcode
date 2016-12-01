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
    vector<int> spiralOrder(vector< vector<int> >& matrix) {
        vector<int> res;

        if (!matrix.size()) return res;
        if (!matrix[0].size()) return res;

        int x0 = 0, x1 = matrix.size()-1;
        int y0 = 0, y1 = matrix[0].size()-1;

        while (x0 <= x1 && y0 <= y1) {
            int x = x0, y = y0;
            
            if (x0 == x1) {
                while (y <= y1) {
                    cout<<"push "<<x<<" "<<y<<endl;
                    res.push_back(matrix[x][y]);
                    y++;
                }
                break;
            }
            
            if (y0 == y1) {
                while (x <= x1) {
                    cout<<"push "<<x<<" "<<y<<endl;
                    res.push_back(matrix[x][y]);
                    x++;
                }
                break;
            }

            while(y < y1) {
                cout<<"push "<<x<<" "<<y<<endl;
                res.push_back(matrix[x][y]);
                y++;
            }
            while(x < x1) {
                cout<<"push "<<x<<" "<<y<<endl;
                res.push_back(matrix[x][y]);
                x++;
            }
            while(y > y0) {
                cout<<"push "<<x<<" "<<y<<endl;
                res.push_back(matrix[x][y]);
                y--;
            }
            while(x > x0){
                cout<<"push "<<x<<" "<<y<<endl;
                res.push_back(matrix[x][y]);
                x--;
            }
            x0++;x1--;
            y0++;y1--;
        }

        return res;
    }
};

int main() {
    vector< vector<int> > matrix;
    vector<int> item0;
    vector<int> item1;
    vector<int> item2;
    vector<int> item3;

    item0.push_back(1);
    item0.push_back(2);
    item0.push_back(3);
    item0.push_back(4);
    item1.push_back(5);
    item1.push_back(6);
    item1.push_back(7);
    item1.push_back(8);
    item2.push_back(9);
    item2.push_back(10);
    item2.push_back(11);
    item2.push_back(12);
    item3.push_back(13);
    item3.push_back(14);
    item3.push_back(15);
    item3.push_back(16);
    
    matrix.push_back(item0);
    matrix.push_back(item1);
    matrix.push_back(item2);
    matrix.push_back(item3);

    Solution s;
    vector<int>res = s.spiralOrder(matrix);

    display(res);
    return 0;
}

