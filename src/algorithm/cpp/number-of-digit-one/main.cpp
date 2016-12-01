#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <cassert>
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
    // bitv=0: higher*bit
    // bitv=1: higher*bit + lower
    // bitv>1: (higher+1)*bit
    int countDigitOne(int n) {
        int count = 0;
        long long nn = n;
        long long bit = 1;
        while(bit <= nn) {
            int higher = n / bit;
            int lower = n % bit;
            int bitv = higher % 10;
            higher /= 10;
            if (bitv == 0) {
                count += (higher * bit);
            } else if (bitv == 1) {
                count += (higher * bit + lower + 1);
            } else if (bitv > 1) {
                count += ((higher+1) * bit);
            }
            bit *= 10;
        }
        return count;
    }
};

int main() {
    Solution s;
    cout<<s.countDigitOne(123)<<endl;
    return 0;
}

