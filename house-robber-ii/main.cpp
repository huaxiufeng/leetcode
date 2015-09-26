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
    int max(int a, int b) {
        return a>b?a:b;
    }

    int rob0(vector<int>& nums) {
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

    int rob(vector<int>& nums) {
        if (!nums.size()) {
            return 0;
        }
        if (nums.size() == 1) {
            return nums[0];
        }
        vector<int> nums0(nums.begin(), nums.end()-1);
        vector<int> nums1(nums.begin()+1, nums.end());
        return max(rob0(nums0), rob0(nums1));
    }
};

int main() {
    int arr[] = {0,0};
    vector<int> nums(arr, arr+sizeof(arr)/sizeof(int));
    Solution s;
    cout<<s.rob(nums)<<endl;
    return 0;
}

