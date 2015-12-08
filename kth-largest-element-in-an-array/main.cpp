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
    int findKthLargest(vector<int>& nums, int k) {
        vector<int> hp(nums.begin(), nums.begin()+k);
        make_heap(hp.begin(), hp.end(), greater<int>());
        for (int i = k; i < nums.size(); i++) {
            if (nums[i] <= hp.front()) {
                continue;
            }
            pop_heap(hp.begin(), hp.end(), greater<int>()); hp.pop_back();
            hp.push_back(nums[i]), push_heap(hp.begin(), hp.end(), greater<int>());
        }
        return hp.front();
    }
};

int main() {
    int arr[]={15,1,12,20,30,7,3,9};
    vector<int> nums(arr, arr+sizeof(arr)/sizeof(int));
    cout<<"nums: ";display(nums);

    Solution s;
    cout<<s.findKthLargest(nums, 3)<<endl;
    return 0;
}

