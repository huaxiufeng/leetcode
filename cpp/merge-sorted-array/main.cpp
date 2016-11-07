/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
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
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int idx1 = 0, idx2 = 0;
        vector<int> res;
        while (idx1 < m && idx2 < n) {
            if (nums1[idx1] < nums2[idx2]) {
                res.push_back(nums1[idx1]);
                idx1++;
            } else {
                res.push_back(nums2[idx2]);
                idx2++;
            }
        }
        while (idx1 < m) {
            res.push_back(nums1[idx1]);
            idx1++;
        }
        while (idx2 < n) {
            res.push_back(nums2[idx2]);
            idx2++;
        }
        nums1 = res;
    }
};

int main() {
    int arr1[] = {1,7,9,10};
    vector<int> nums1(arr1, arr1+sizeof(arr1)/sizeof(int));
    int arr2[] = {1,3,4,19,20};
    vector<int> nums2(arr2, arr2+sizeof(arr2)/sizeof(int));

    Solution s;
    s.merge(nums1, nums1.size(), nums2, nums2.size());

    display(nums1);

    return 0;
}

