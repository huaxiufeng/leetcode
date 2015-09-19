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
    void moveZeroes(vector<int>& nums) {
        int p = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i]) {
                nums[p++] = nums[i];
            }
        }
        while (p < nums.size()) {
            nums[p++] = 0;
        }
    }
};

int main() {
    int arr[] = {0,1,0,3,0,12};
    vector<int> nums(arr, arr+sizeof(arr)/sizeof(int));

    display(nums);

    Solution s;
    s.moveZeroes(nums);
    
    display(nums);
    
    return 0;
}

