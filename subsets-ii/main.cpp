/*
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
[3],
[1],
[2],
[1,2,3],
[1,3],
[2,3],
[1,2],
[]
]
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
    vector< vector<int> > subsets0(int begin, int end, vector<int>& nums) {
        vector< vector<int> > res;
        if (begin == end) {
            vector<int> item;
            res.push_back(item);
            item.push_back(nums[begin]);
            res.push_back(item);
            return res;
        }
        
        vector< vector<int> > res0 = subsets0(begin+1, end, nums);
        for (int i = 0; i < res0.size(); i++) {
            if (find(res.begin(), res.end(), res0[i]) == res.end()) {
                res.push_back(res0[i]);
            }
            res0[i].insert(res0[i].begin(), nums[begin]);
            if (find(res.begin(), res.end(), res0[i]) == res.end()) { 
                res.push_back(res0[i]);
            }
        }
        return res;
    }
    vector< vector<int> > subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        return subsets0(0, nums.size()-1, nums);
    }
};

int main() {
    int arr[] = {1,2,2};
    vector<int> nums(arr, arr+sizeof(arr)/sizeof(int));
    Solution s;
    vector< vector<int> > res = s.subsetsWithDup(nums);
    for (int i = 0; i < res.size(); i++) {
        display(res[i]);
    }
    return 0;
}

