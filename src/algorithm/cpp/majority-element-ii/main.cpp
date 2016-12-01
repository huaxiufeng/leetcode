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
    vector<int> majorityElement(vector<int>& nums) {
        int item0 = 0, item1 = 0;
        int count0 = 0, count1 = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (count0 == 0 || item0 == nums[i]) {
                item0 = nums[i];
                count0++;
            } else if (count1 == 0 || item1 == nums[i]) {
                item1 = nums[i];
                count1++;
            } else {
                count0--;
                count1--;
            }
        }

        count0 = 0, count1 = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (item0 == nums[i]) {
                count0++;
            } else if (item1 == nums[i]) {
                count1++;
            }
        } 

        vector<int> res;
        if (count0 > nums.size()/3) {
            res.push_back(item0);
        }
        if (count1 > nums.size()/3) {
            res.push_back(item1);
        }
        return res;
    }
};

int main() {
    Solution s;
    cout<<"Hello World"<<endl;
    return 0;
}

