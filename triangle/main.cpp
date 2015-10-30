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
    int minimumLine(vector<int>& line) {
        if (!line.size()) return 0;
        int minval = line[0];
        for (int i = 0; i < line.size(); i++) {
            int n = line[i];
            if (minval > n) minval = n;
        }
        return minval;
    }

    int minimumTotal(vector<vector<int>>& triangle) {
        if (!triangle.size()) return 0;
        if (triangle.size() ==1 ) return minimumLine(triangle[0]);

        vector<vector<int>> resultTriangle = triangle;
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle[i].size(); j++) {
                if (j == 0) {
                    resultTriangle[i][j] = resultTriangle[i-1][j] + triangle[i][j];
                } else if (j == triangle[i].size()-1) {
                    resultTriangle[i][j] = resultTriangle[i-1][j-1] + triangle[i][j];
                } else {
                    int left = resultTriangle[i-1][j-1] + triangle[i][j];
                    int right = resultTriangle[i-1][j] + triangle[i][j];
                    resultTriangle[i][j] = left < right ? left : right;
                }
            }
        }

        return minimumLine(resultTriangle[triangle.size()-1]);
    }
};

int main() {
    vector<int> line1,line2,line3,line4;
    line1.push_back(2);
    line2.push_back(3),line2.push_back(4);
    line3.push_back(6),line3.push_back(5),line3.push_back(7);
    line4.push_back(4),line4.push_back(1),line4.push_back(8), line4.push_back(3);
    vector<vector<int>> triangle;
    triangle.push_back(line1);
    triangle.push_back(line2);
    triangle.push_back(line3);
    triangle.push_back(line4);

    display(triangle);
    Solution s;
    cout<<s.minimumTotal(triangle)<<endl;
    return 0;
}

