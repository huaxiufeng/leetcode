/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

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
/*
    1, Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.

    2, Find the largest index l such that a[k] < a[l]. Since k+1 is such an index, l is well defined and satisfies k < l.

    3, Swap a[k] with a[l].

    4, Reverse the sequence from a[k+1] up to and including the last element a[n].
*/
    void nextPermutation(vector<int>& nums) {
        if (nums.size() <= 1) {
            return;
        }

        int k = -1, l = -1;
        for (int i = 0; i < nums.size()-1; i++) {
            if (nums[i] < nums[i+1]) {
                k = i;
            }
        }
        if (k == -1) {
            // this is the last sequence, return the first one;
            sort(nums.begin(), nums.end());
            return;
        }

        for (int i = k+1; i < nums.size(); i++) {
            if (nums[k] < nums[i]) {
                l = i;
            }
        }

        swap(nums[k], nums[l]);

        reverse(nums.begin()+k+1, nums.end());
    }
};

int main() {
    int array[] = {1,1};
    vector<int> nums(array, array+sizeof(array)/sizeof(int));
    
    Solution s;
    s.nextPermutation(nums);
    display(nums);
    cout<<"Hello World"<<endl;
    return 0;
}

