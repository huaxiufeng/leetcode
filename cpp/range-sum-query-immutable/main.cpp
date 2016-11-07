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

template <typename T>
void display(vector<vector<T>>& array) {
    for (int i = 0; i < array.size(); i++) {
        display(array[i]);
    }
}

class Solution {
public:

};

class NumArray {
public:
    NumArray(vector<int> &nums):
    table(nums.size()+1, 0) {
        for (int i = 0; i < nums.size(); i++) {
            table[i+1] = table[i] + nums[i];
        }
    }

    int sumRange(int i, int j) {
        int sz = table.size();
        if (i < 0 || j >= sz) {
            return 0;
        }
        return table[j+1] - table[i];
    }

    vector<int> table;
};

int main() {
    int arr[] = {-2, 0, 3, -5, 2, -1};
    vector<int> nums(arr, arr+sizeof(arr)/sizeof(int));

    NumArray na(nums);
    
    cout<<na.sumRange(0,2)<<endl;
    cout<<na.sumRange(2,5)<<endl;
    cout<<na.sumRange(0,5)<<endl;
    return 0;
}

