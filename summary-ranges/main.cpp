/*
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
*/

#include <cstdio>
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

template <typename T>
void display(vector<T> array) {
    for (int i = 0; i < array.size(); i++) {
        cout<<array[i]<<" \n";
    }
    cout<<endl;
}

class Solution {
public:
    string genRange(int begin, int end) {
        char buf[128];
        if (begin == end) {
            snprintf(buf, sizeof(buf), "%d", begin);
        } else {
            snprintf(buf, sizeof(buf), "%d->%d", begin, end);
        }
        return buf;
    }
    vector<string> summaryRanges(vector<int>& nums) {
        vector<string> res;
        if (!nums.size()) {
            return res;
        }
        int begin = nums[0];
        int end = begin;
        int i = 1;
        do {
            if (i < nums.size()) {
                if (nums[i] != end + 1) {
                    res.push_back(genRange(begin, end));
                    begin = nums[i];
                }
                end = nums[i];
            }
            if (i >= nums.size() - 1) {
                res.push_back(genRange(begin, end));
                break;
            }
            i++;
        } while (true);
        return res;
    }
};

int main() {
    //int arr[] = {0};
    int arr[] = {0,1,2,4,5,7};
    vector<int> nums(arr, arr+sizeof(arr)/sizeof(int));
    Solution s;
    vector<string> res = s.summaryRanges(nums);
    display(res);
    return 0;
}

