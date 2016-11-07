/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
For example, given array S = {-1 2 1 -4}, and target = 1.
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {        
        if (nums.size() < 3) {
            return 0;
        }
        int closest = nums[0]+nums[1]+nums[2];
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size()-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i+1, k = nums.size()-1;
            while (j < k) {
                int target2 = target - nums[i];
                int closest2 = closest - nums[i];
                int sum = nums[j] + nums[k];
                if (abs(sum-target2) < abs(closest2-target2)) {
                    closest = sum + nums[i];
                }
                if (sum < target2) {
                    j++;
                } else if (sum > target2) {
                    k--;
                } else {
                    return target;
                }
            }
        }
        return closest;
 
    }    
};

int main() {
    int args[] = {-1, 2, 1, -4, -3, 3, 6};
    vector<int> arg(args, args+sizeof(args)/sizeof(int));

    cout<<"input:\n";
    for (int i = 0; i < arg.size(); i++) {
        cout<<arg[i]<<"\t";
    }  
 
    Solution s;
    int res = s.threeSumClosest(arg, 1);

    cout<<"\nsorted input:\n";
    for (int i = 0; i < arg.size(); i++) {
        cout<<arg[i]<<"\t";
    }

    cout<<"\nresult: "<<res<<"\n";
 
    return 0;
}

