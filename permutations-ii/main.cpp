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

template <typename T>
void display(vector<vector<T>>& array) {
    for (int i = 0; i < array.size(); i++) {
        display(array[i]);
    }
}

class Solution {
public:
    void permuteImpl(vector<int>& nums, int index, vector<vector<int>>& result) {
        if (index == nums.size()) {
            result.push_back(nums);
            return;
        }
        
        set<int> used;

        for (int i = index; i < nums.size(); i++) {
            if (used.find(nums[i]) != used.end()) {
                continue;
            }
            swap(nums[i], nums[index]);
            permuteImpl(nums, index+1, result);
            swap(nums[i], nums[index]);
            used.insert(nums[i]);
        }
    }

    vector<vector<int>> permuteUnique(vector<int>& nums) {
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
    int num[] = {1,1,2};
    vector<int> nums(num, num+sizeof(num)/sizeof(int));
    Solution s;
    vector<vector<int>> res = s.permuteUnique(nums);
    display(res);
    return 0;
}

