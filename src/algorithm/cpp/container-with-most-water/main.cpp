#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    /*
    int maxArea(vector<int>& height) {
        int res = 0;
        for (int i = 0; i < height.size(); i++) {
            for (int j = i+1; j < height.size(); j++) {
                int w = j-i;
                int h = height[j] > height[i] ? height[i] : height[j];
                int area = w * h;
                res = res > area ? res : area;
            }
        }
        return res;
    }
    */

    int maxArea(vector<int>& height) {
        int res = 0;
        int idx0 = 0, idx1 = height.size()-1;
        while (idx1 > idx0) {
            int h0 = height[idx0];
            int h1 = height[idx1];
            int area = (idx1-idx0)*(h0>h1?h1:h0);
            res = area>res?area:res;
            if (height[idx0] > height[idx1]) {
                idx1--;
            } else {
                idx0++;
            }
        }
        return res;
    }
};

int main() {
    Solution s;
    cout<<"Hello World"<<endl;
    return 0;
}

