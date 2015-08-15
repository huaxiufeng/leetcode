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
    vector< vector<int> > combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        
        cout<<"combinationSum ";
        for (int i = 0; i < candidates.size(); i++) {
            cout<<candidates[i]<<" ";
        }
        cout<<" to target "<<target<<endl;

        vector< vector<int> > res;
        if (candidates.size() == 0) {
            return res;
        }
        if (candidates.size() == 1) {
            if (target == candidates[0]) {
                vector<int> item(1, candidates[0]);
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
                if (find(res.begin(), res.end(), item) == res.end()) {
                    res.push_back(item);
                }
                continue;
            }

            vector<int> candidates_sub(candidates.begin()+i+1, candidates.end());
            vector< vector<int> > res_sub = combinationSum2(candidates_sub, target-can);
            for (int j = 0; j < res_sub.size(); j++) {
                vector<int> item = res_sub[j];
                item.insert(item.begin(), 1, can);
                if (find(res.begin(), res.end(), item) == res.end()) {
                    res.push_back(item);
                }
            }
        }

        return res;
    }
};

int main() {
    //int array[] = {10,1,2,7,6,1,5};
    int array[] = {1,1};
    vector<int> nums(array, array+sizeof(array)/sizeof(int));

    Solution s;
    vector< vector<int> > res = s.combinationSum2(nums, 1);
    cout<<"final result:"<<endl;
    for (int i = 0; i < res.size(); i++) {
        display(res[i]);
    }
    return 0;
}

