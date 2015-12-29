/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
    Given [10, 9, 2, 5, 3, 7, 101, 18],
    The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

    Your algorithm should run in O(n2) complexity.

    Follow up: Could you improve it to O(n log n) time complexity?
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

template <typename T>
void display(vector<vector<T>>& array) {
    for (int i = 0; i < array.size(); i++) {
        display(array[i]);
    }
}


class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int sz = nums.size();
        if (sz <= 1) {
            return sz;
        } 

        vector<int> lis(sz, 1);
        int longest = 1;
        for (int i = 0; i < sz; i++) {
            int lis_i = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j] && lis[j]+1 > lis_i) {
                    lis_i = lis[j]+1;
                }
            }
            lis[i] = lis_i;
            if (lis_i > longest) {
                longest = lis_i;
            }
        }
        return longest;
    }
};

int main() {
    int arr[] = {1,3,6,7,9,4,10,5,6};
    vector<int> nums(arr, arr+sizeof(arr)/sizeof(int));
    Solution s;
    cout<<s.lengthOfLIS(nums)<<endl;
    return 0;
}

