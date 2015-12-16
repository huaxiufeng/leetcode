#include <iostream>
#include <string>
#include <vector>
#include <set>
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
    int firstMissingPositive(vector<int>& nums) {
        set<int> s;
        int maxp = -1;
        int minp = std::numeric_limits<int>::max();
        for (int i = 0; i < nums.size(); i++) {
            s.insert(nums[i]);
            if (nums[i] > 0) {
                if (nums[i] > maxp) {
                    maxp = nums[i];
                }
                if (nums[i] < minp) {
                    minp = nums[i];
                }
            }
        }
        if (maxp == -1) {
            return 1;
        }
        if (minp > 1) {
            return 1;
        }
        for (int i = minp; i <= maxp + 1; i++) {
            if (s.find(i) == s.end()) {
                return i;
            }
        }
        return 0;
    }
};

int main() {
    int num[] = {0,1,2,2,2,5};
    vector<int> nums(num, num+sizeof(num)/sizeof(int));
    Solution s;
    cout<<s.firstMissingPositive(nums)<<endl;
    return 0;
}

