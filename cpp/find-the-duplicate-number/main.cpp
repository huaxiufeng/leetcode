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
    int findDuplicate(vector<int>& nums) {
        int len = nums.size(), left = 0, right = len-1;
        while(left < right) {
            int mid = (left+right)>>1;
            int count = 0;
            for(int i=0; i<len;++i) {
                if(nums[i]<=mid) ++count; 
            }
            if(count>mid) right = mid; 
            else left = mid+1;
        }
        return left;
    }
};

int main() {
    //int arr[] = {2,4,3,5,1,3};
    //int arr[] = {3,2,4,5,1,3};
    int arr[] = {1,2,2,4,5,6};
    vector<int> nums(arr, arr+sizeof(arr)/sizeof(int));
    Solution s;
    cout<<s.findDuplicate(nums)<<endl;
    return 0;
}

