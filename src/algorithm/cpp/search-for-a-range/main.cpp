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
    vector<int> searchRange(vector<int>& nums, int target) {
        int begin = 0, end = nums.size()-1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                begin = mid + 1;
            } else {
                break;
            }
        }

        int idx[2] = {-1, -1};
        if (begin <= end) {
            int mid = (begin + end) / 2;
            begin = mid;
            end = mid;
            while (nums[begin] == target) {
                if (begin-1 < 0) break;
                begin--;
            }
            if (nums[begin] != target) begin++;
            while (nums[end] == target) {
                if (end+1 > nums.size()-1) break;
                end++;
            }
            if (nums[end] != target) end--;
            idx[0] = begin;
            idx[1] = end;
        }
        return vector<int>(idx, idx+2);
    }
};

int main() {
    Solution s;
    int array[] = {1,3};
    vector<int> nums(array, array+sizeof(array)/sizeof(int));
    vector<int> res = s.searchRange(nums, 1);
    display(res);
    cout<<"Hello World"<<endl;
    return 0;
}

