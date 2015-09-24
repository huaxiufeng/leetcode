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
    int rob(vector<int>& nums) {
        if (!nums.size()) {
            return 0;
        }
        if (nums.size() == 1) {
            return nums[0];
        }
        vector<int> robbed(nums.size(), 0);
        robbed[0] = nums[0];
        robbed[1] = nums[1] > nums[0] ? nums[1] : nums[0];
        for (int i = 2; i < nums.size(); i++) {
            if (robbed[i-1] > robbed[i-2] + nums[i]) {
                robbed[i] = robbed[i-1];
            } else {
                robbed[i] = robbed[i-2] + nums[i];
            }
        }
        return robbed[nums.size()-1];
    }
};

int main() {
    int arr[] = {0,0};
    vector<int> nums(arr, arr+sizeof(arr)/sizeof(int));
    Solution s;
    cout<<s.rob(nums)<<endl;
    return 0;
}

