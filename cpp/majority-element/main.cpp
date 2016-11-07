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
    int majorityElement(vector<int>& nums) {
        int item = 0;
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (count == 0 || item == nums[i]) {
                item = nums[i];
                count++;
            } else {
                count--;
            }
        }
        return item;
    }
};

int main() {
    Solution s;
    cout<<"Hello World"<<endl;
    return 0;
}

