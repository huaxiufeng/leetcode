#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <set>
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
    bool containsDuplicate(vector<int>& nums) {
        set<int> ht;
        for (int i = 0; i < nums.size(); i++) {
            if (ht.find(nums[i]) == ht.end()) {
                ht.insert(nums[i]);
            } else {
                return true;
            }
        }
        return false;
    }
};

int main() {
    Solution s;
    cout<<"Hello World"<<endl;
    return 0;
}

