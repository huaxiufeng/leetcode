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
    void reverse(vector<int>& nums, int k, int n) {
        int b = k, e = k+n-1;
        while (b < e) {
            int temp = nums[b];
            nums[b] = nums[e];
            nums[e] = temp;
            b++,e--;
        }
    }
    
    void rotate(vector<int>& nums, int k) {
        int numsz = nums.size();
        if (numsz <= 1) {
            return;
        }
        k = k % numsz;
        if (!k) {
            return;
        }

        reverse(nums, 0, numsz-k);
        reverse(nums, numsz-k, k);
        reverse(nums, 0, numsz);
    }
};

int main() {
    int arr[] = {1,2,3,4,5,6,7};
    vector<int> nums(arr, arr+sizeof(arr)/sizeof(int));

    Solution s;
    s.rotate(nums, 3);
    display(nums);
    return 0;
}

