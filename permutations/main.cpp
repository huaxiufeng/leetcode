#include <iostream>
#include <string>
#include <cstring>
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
    void display(vector<int>& v) {
        for (int i = 0; i < v.size(); i++) {
            cout<<v[i]<<" ";
        }
        cout<<endl;
    }
/*
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
*/
/*
    vector< vector<int> > permute(vector<int>& nums) {
        cout<<"permuting ... ";
        display(nums);
        vector< vector<int> > res;
        if (nums.size() == 1) {
            res.push_back(nums);
            return res;
        }
        
        for (int i = 0; i < nums.size(); i++) {
            swap(nums[0], nums[i]);
            vector<int> nums0 = vector<int>(nums.begin()+1, nums.end());
            vector< vector<int> > res0 = permute(nums0);
            for (int j = 0; j < res0.size(); j++) {
                res0[j].insert(res0[j].begin(), nums[0]);
                res.push_back(res0[j]);
                cout<<"push to result ";
                display(res0[j]);
            }
            swap(nums[0], nums[i]);
        }
        return res;
    }
*/
    void permuteImpl(vector<int>& nums, int index, vector<vector<int>>& result) {
        if (index == nums.size()) {
            result.push_back(nums);
            return;
        }

        for (int i = index; i < nums.size(); i++) {
            swap(nums[i], nums[index]);
            permuteImpl(nums, index+1, result);
            swap(nums[i], nums[index]);
        }
    }

    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        if (nums.size() == 1) {
            res.push_back(nums);
            return res;
        }

        permuteImpl(nums, 0, res);
        return res;
    }
};

int main() {
    int num[] = {1,2,3};
    vector<int> nums(num, num+sizeof(num)/sizeof(int));
    Solution s;
    vector<vector<int>> res = s.permute(nums);
    display(res);
    return 0;
}

