/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
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

    int maxSubArray(vector<int>& nums) {
        if (nums.size() == 0) {
            return 0;
        }
       
        int max_ending = nums[0]; 
        int max_so_far = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            if (max_ending < 0) {
                max_ending = nums[i];
            } else {
                max_ending += nums[i];
            }
            max_so_far = max_so_far>max_ending?max_so_far:max_ending;
            cout<<"max_ending "<<max_ending<<" max_so_far "<<max_so_far<<endl;
        }

        return max_so_far;
    }
};

int main() {
    int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
    //int arr[] = {-2,-1};
    vector<int> nums(arr, arr+sizeof(arr)/sizeof(int));
    display(nums);
    Solution s;
    cout<<s.maxSubArray(nums)<<endl;
    return 0;
}

