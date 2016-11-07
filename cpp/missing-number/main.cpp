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
    int missingNumber(vector<int>& nums) {
        int res = 0;
        for (int i = 1; i <= nums.size(); i++) {
            res ^= i;
            res ^= nums[i-1];
        }
        return res;
    }
};

int main() {
    int arr[] = {0,1,3};
    vector<int> nums(arr, arr+sizeof(arr)/sizeof(int));

    Solution s;
    cout<<s.missingNumber(nums)<<endl;
    return 0;
}

