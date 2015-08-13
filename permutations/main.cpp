#include <iostream>
#include <string>
#include <cstring>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    void display(vector<int>& v) {
        for (int i = 0; i < v.size(); i++) {
            cout<<v[i]<<" ";
        }
        cout<<endl;
    }

    vector< vector<int> > permute(vector<int>& nums) {
        cout<<"permuting ... ";
        display(nums);
        vector< vector<int> > res;
        if (nums.size() == 1) {
            res.push_back(nums);
            return res;
        }
        int n = nums[0];
        int sz = nums.size()-1;
        vector<int> nums0(nums.begin()+1, nums.end());
        vector< vector<int> > res0 = permute(nums0);
        for (int i = 0; i < res0.size(); i++) {
            for (int j = 0; j <= sz; j++) {
                vector<int> item = res0[i];
                item.insert(item.begin()+j, n);
                display(item);
                res.push_back(item);
            } 
        }
        return res;
    }
};

int main() {
    int num[] = {1,2,3};
    vector<int> nums(num, num+3);
    Solution s;
    s.permute(nums);
    return 0;
}

