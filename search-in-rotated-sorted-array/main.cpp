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
    int search(vector<int>& nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left+right)/2;
        if (target == nums[mid]) {
            return mid;
        }

        if (nums[mid] < nums[left]) {
            // right side is accending
            if (target >= nums[mid+1] && target <= nums[right]) {
                // target can only in right side
                return search(nums, target, mid+1, right);
            } else {
                return search(nums, target, left, mid-1);
            }
        } else if (nums[mid] > nums[left]) {
            // left side is accending
            if (target >= nums[left] && target <= nums[mid-1]) {
                return search(nums, target, left, mid-1);
            } else {
                return search(nums, target, mid+1, right);
            }
        } else {
            // left side is all equal
            return search(nums, target, mid+1, right);
        }
    }

    int search(vector<int>& nums, int target) {
        if (0 == nums.size()) {
            return -1;
        }
        return search(nums, target, 0, nums.size()-1);
    }
};

int main() {
    int arr[] = {4,5,6,7,0,1,2,3};
    vector<int> nums(arr, arr+sizeof(arr)/sizeof(int));
    Solution s;
    cout<<s.search(nums, 5)<<endl;
    cout<<s.search(nums, 8)<<endl;
    return 0;
}

