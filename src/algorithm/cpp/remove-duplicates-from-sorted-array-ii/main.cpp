/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
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
    int removeDuplicates(vector<int>& nums) {
        int numlen = nums.size();
        if (!numlen) {
            return 0;
        }
        int total = 0;
        int curcnt = 0;
        int index0 = 0, index1 = 0;
        while (index1 < numlen) {
            while (nums[index1] == nums[index0]) {
                index1++;
                if (curcnt < 2) {
                    curcnt++;
                }
                if (index1 >= numlen) {
                    break;
                }
            }
            int extra = index1 - index0 - 2;
            if (extra > 0) {
                for (int i = index1; i < numlen; i++) {
                    nums[i-extra] = nums[i];
                }
                numlen -= extra;
                index1 -= extra;
            } 
            index0 = index1;
            total += curcnt;
            curcnt = 0;
        }
        return total; 
    }
};

int main() {
    int arr[] = {1,1,1,2,2,5};
    //int arr[] = {1,1,1,1,1,1,1,1};
    //int arr[] = {1};
    vector<int> nums(arr, arr+sizeof(arr)/sizeof(int));

    Solution s;
    cout<<s.removeDuplicates(nums)<<endl;
    display(nums);
    return 0;
}

