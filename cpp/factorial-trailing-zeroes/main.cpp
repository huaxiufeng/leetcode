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
    int trailingZeroes(int n) {
        int count = 0;
        int d = n / 5;
        while (d > 0) {
            count += d;
            d = d / 5;
        } 
        return count;
    }
};

int main() {
    Solution s;
    cout<<s.trailingZeroes(1808548329)<<endl;
    return 0;
}

