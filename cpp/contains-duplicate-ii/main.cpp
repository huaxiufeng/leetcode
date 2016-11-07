#include <iostream>
#include <string>
#include <vector>
#include <map>
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
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        map<int,int> ht;
        for (int i = 0; i < nums.size(); i++) {
            if (ht.find(nums[i]) != ht.end()) {
                if (i - ht[nums[i]] <= k) {
                    return true;
                } else {
                    ht[nums[i]] = i;
                }
            } else {
                ht[nums[i]] = i;
            }
        }
        return false;
    }
};

int main() {
    int arr[] = {1,0,1,1};
    vector<int> nums(arr, arr+sizeof(arr)/sizeof(int));
    Solution s;
    cout<<s.containsNearbyDuplicate(nums, 1)<<endl;
    return 0;
}

