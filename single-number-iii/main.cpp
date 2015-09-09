/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*/

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
    vector<int> singleNumber(vector<int>& nums) {
        int xor_res = 0;
        for (int i = 0; i < nums.size(); i++) {
            xor_res ^= nums[i];
        }
        vector<int> res;
        int flag = 1;
        while (!(flag&xor_res) && flag>0) {
            flag = flag<<1;
        }
        if (flag <= 0) {
            return res;
        }
        int a = 0, b = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] & flag) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        res.push_back(a);
        res.push_back(b);
        return res;
    }
};

int main() {
    int arr[] = {1,2,1,3,2,5};
    vector<int> nums(arr, arr+sizeof(arr)/sizeof(int));

    Solution s;
    vector<int> res = s.singleNumber(nums);

    display(res);
    return 0;
}

