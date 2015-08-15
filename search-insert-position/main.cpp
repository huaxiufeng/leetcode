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
    int searchInsert(vector<int>& nums, int target) {
        if (nums.size() == 0) {
            return 0;
        }
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.size()-1]) {
            return nums.size();
        }

        int begin = 0, end = nums.size() - 1;

        while (begin <= end) {
            int mid = (begin+end) / 2;
            if (nums[mid] < target) {
                begin = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return begin;
    }
};

int main() {
    int array[] = {1,3,5,6};
    vector<int> nums(array, array + sizeof(array)/sizeof(int));

    Solution s;
    cout<<s.searchInsert(nums, 5)<<endl;
    cout<<s.searchInsert(nums, 2)<<endl;
    cout<<s.searchInsert(nums, 7)<<endl;
    cout<<s.searchInsert(nums, 0)<<endl;
    return 0;
}

