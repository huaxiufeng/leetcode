/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
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
    /*
    bool jump(int index, vector<int>& nums) {
        //cout<<"checking index "<<index<<" | "<<nums.size()<<endl;
        if (index == nums.size()-1) {
            return true;
        }
        if (index > nums.size()-1) {
            return false;
        }
        int value = nums[index];
        if (value == 0) {
            return false;
        }

        bool res = false;
        for (int i = 1; i <= value && index+i < nums.size(); i++) {
            res |= jump(index+i, nums);
            if (res) {
                break;
            }
        }
        //cout<<"index "<<index<<" res "<<res<<endl;
        return res;
    }

    bool canJump(vector<int>& nums) {
       return jump(0, nums); 
    }
    */
    
    bool canJump(vector<int>& nums) {
        if (nums.size() <= 1) {
            return true;
        }
        
        int max_steps_to_jump = nums[0];
        
        for (int i = 1; i < nums.size(); i++) {
            if (max_steps_to_jump == 0) {
                return false;
            }

            max_steps_to_jump--;

            if (max_steps_to_jump < nums[i]) {
                max_steps_to_jump = nums[i];
            }

            if (i + max_steps_to_jump >= nums.size()-1) {
                return true;
            }
        }

        return false;
    }
};

int main() {
    //int array[] = {2,3,1,1,4};
    int array[] = {3,2,1,0,4};
    //int array[] = {1,2,2,6,3,6,1,8,9,4,7,6,5,6,8,2,6,1,3,6,6,6,3,2,4,9,4,5,9,8,2,2,1,6,1,6,2,2,6,1,8,6,8,3,2,8,5,8,0,1,4,8,7,9,0,3,9,4,8,0,2,2,5,5,8,6,3,1,0,2,4,9,8,4,4,2,3,2,2,5,5,9,3,2,8,5,8,9,1,6,2,5,9,9,3,9,7,6,0,7,8,7,8,8,3,5,0};
    //int array[] = {1,2,2,6,3,6,1,8,9};
    vector<int> nums(array, array+sizeof(array)/sizeof(int));
    display(nums);
    Solution s;
    cout<<s.canJump(nums)<<endl;
    return 0;
}

