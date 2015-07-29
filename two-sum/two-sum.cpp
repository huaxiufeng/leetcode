//============================================================================
// Name        : two-sum.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/

#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
/*
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> ret;
        if (nums.size() < 2) {
            return ret;
        }
        size_t begin = 0, end = nums.size() - 1;
        while (end > begin) {
            int sum = nums[begin] + nums[end];
            if (sum == target) {
                ret.push_back(begin+1);
                ret.push_back(end+1);
                return ret;
            } else if (sum > target) {
                end--;
            } else if (sum < target) {
                begin++;
            }
        }
        return ret;
    }
*/
/*
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> ret;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i+1; j < nums.size(); j++) {
                if (target == nums[i] + nums[j]) {
                    ret.push_back(i+1);
                    ret.push_back(j+1);
                    return ret;
                }
            }
        }
        return ret;
    }
*/
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> ret;
        map<int, int> table;
        for (int i = 0; i < nums.size(); i++) {
            table[nums[i]] = i;
        }
        for (int i = 0; i < nums.size(); i++) {
            int obj = target - nums[i];
            if (table.find(obj) != table.end()) {
                int index = table[obj];
                if (index == i) {
                    continue;
                }
                ret.push_back(i+1);
                ret.push_back(index+1);
                return ret;
            }
        }
        return ret;
    }
};

int main() {
	cout << "!!!Hello World!!!" << endl; // prints !!!Hello World!!!
	return 0;
}
