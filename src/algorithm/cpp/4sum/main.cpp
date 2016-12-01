#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector< vector<int> > threeSum(vector<int>& nums, int target) {
        vector< vector<int> > res;
        if (nums.size() < 3) {
            return res;
        }
        for (int i = 0; i < nums.size()-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i+1, k = nums.size()-1;
            int target2 = -1*nums[i] + target;
            while (j < k) {
                if (nums[j]+nums[k] < target2) {
                    j++;
                } else if (nums[j]+nums[k] > target2) {
                    k--;
                } else {
                    vector<int> item;
                    item.push_back(nums[i]);
                    item.push_back(nums[j]);
                    item.push_back(nums[k]);
                    res.push_back(item);
                    while (j+1 < nums.size() && nums[j+1] == nums[j]) {
                        j++;
                    }
                    while (k-1 > i && nums[k-1] == nums[k]) {
                        k--;
                    }
                    j++;
                    k--;
                }
            }
        }
        return res;
    }

    vector< vector<int> > fourSum(vector<int>& nums, int target) {
        vector< vector<int> > res;
        if (nums.size() < 4) {
            return res;
        }

        sort(nums.begin(), nums.end());
        
        for (int i = 0; i < nums.size()-3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target3 = -1*nums[i] + target;
            vector<int> nums3(nums.begin()+i+1, nums.end());
            vector< vector<int> > res3 = threeSum(nums3, target3);
            for (int j = 0; j < res3.size(); j++) {
                res3[j].insert(res3[j].begin(), nums[i]);
                res.push_back(res3[j]);
            }
        }

        return res;
    }

};

int main() {
    //int args[] = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,28,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,30,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
    //int args[] = {-2,0,0,2,2};
    int args[] = {1, 0, -1, 0, -2, 2};
    vector<int> arg(args, args + sizeof(args)/sizeof(int));
    
    cout<<"input:\n";
    for (int i = 0; i < arg.size(); i++) {
        cout<<arg[i]<<"\t";
    }  
  
    Solution s;
    vector< vector<int> > res = s.fourSum(arg, 0);

    cout<<"\nsorted input:\n";
    for (int i = 0; i < arg.size(); i++) {
        cout<<arg[i]<<"\t";
    }

    cout<<"\nresult:\n";
    for (int i = 0; i < res.size(); i++) {
        for (int j = 0; j < res[i].size(); j++) {
            cout<<res[i][j]<<"\t";
        }
        cout<<endl;
    }
    return 0;
}

