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
    vector< vector<int> > combinationSum(vector<int>& candidates, int target) {
        cout<<"combinationSum ";
        for (int i = 0; i < candidates.size(); i++) {
            cout<<candidates[i]<<" ";
        }
        cout<<" to target "<<target<<endl;

        sort(candidates.begin(), candidates.end());
        vector< vector<int> > res;
        if (candidates.size() == 0) {
            return res;
        }
        if (candidates.size() == 1) {
            if (target % candidates[0] == 0) {
                int count = target / candidates[0];
                vector<int> item(count, candidates[0]);
                res.push_back(item);
                return res;
            }
        }

        for (int i = 0; i < candidates.size(); i++) {
            int can = candidates[i];
            if (can > target) {
                continue;
            }
            if (can == target) {
                vector<int> item(1, can);
                res.push_back(item);
                continue;
            }
            if (target % can == 0) {
                int count = target / can;
                vector<int> item(count, can);
                res.push_back(item);
            }

            vector<int> candidates_sub(candidates.begin()+i+1, candidates.end());
            for (int n = 1; can*n < target; n++) {
                vector< vector<int> > res_sub = combinationSum(candidates_sub, target-can*n);
                for (int j = 0; j < res_sub.size(); j++) {
                    vector<int> item = res_sub[j];
                    item.insert(item.begin(), n, can);
                    res.push_back(item);
                }
            }
        }

        return res;
    }
};

int main() {
    int array[] = {2,3,6,7};
    vector<int> nums(array, array+sizeof(array)/sizeof(int));

    Solution s;
    vector< vector<int> > res = s.combinationSum(nums, 7);
    cout<<"final result:"<<endl;
    for (int i = 0; i < res.size(); i++) {
        display(res[i]);
    }
    return 0;
}

