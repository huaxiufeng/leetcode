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
/*
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
            res.push_back(res0[i]);
            res0[i].insert(res0[i].begin(), nums[begin]);
            res.push_back(res0[i]);
        }
        return res;
    }
    vector< vector<int> > subsets(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        return subsets0(0, nums.size()-1, nums);
    }
*/
    void subsetsImpl(const vector<int>& nums, int index, int left, vector<int>& cur, vector< vector<int> >& res) {
        if (left == 0) {
            res.push_back(cur);
            return;
        }
        if (index >= nums.size()) {
            return;
        }
        cur.push_back(nums[index]);
        subsetsImpl(nums, index+1, left-1, cur, res);
        cur.pop_back();
        subsetsImpl(nums, index+1, left, cur, res);
    }
    vector< vector<int> > subsets(vector<int>& nums) {
        vector< vector<int> > res;
        vector<int> cur;
        sort(nums.begin(), nums.end());
        for (int i = 0; i <= nums.size(); i++) {
            subsetsImpl(nums, 0, i, cur, res);
        }
        return res;
    }
};

int main() {
    int arr[] = {4,1,0};
    vector<int> nums(arr, arr+sizeof(arr)/sizeof(int));
    Solution s;
    vector< vector<int> > res = s.subsets(nums);
    for (int i = 0; i < res.size(); i++) {
        display(res[i]);
    }
    return 0;
}

