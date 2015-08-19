/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.

Hint:

The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
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
    int min(int a, int b, int c) {
        int m = a<b?a:b;
        return m<c?m:c;
    }

    int nthUglyNumber(int n) {
        if (n <= 1) {
            return 1;
        }
        
        vector<int> uglyn(1,1);
        int count = 1;
        int i=0, j=0 ,k=0;

        while (n > count) {
            //display(uglyn);
            int u = min(uglyn[i]*2, uglyn[j]*3, uglyn[k]*5);
            uglyn.push_back(u);

            if (u == uglyn[i]*2) i++;
            if (u == uglyn[j]*3) j++;
            if (u == uglyn[k]*5) k++;
            count++;
        }
        return uglyn[n-1];
    }
};

int main() {
    Solution s;
    cout<<s.nthUglyNumber(10)<<endl;
    return 0;
}

