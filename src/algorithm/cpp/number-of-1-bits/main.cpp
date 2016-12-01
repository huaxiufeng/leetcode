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
    int hammingWeight(uint32_t n) {
        int w = 0;
        while (n) {
            n = n&(n-1);
            w++;
        }
        return w;
    }
};

int main() {
    Solution s;
    cout<<s.hammingWeight(257)<<endl;
    return 0;
}

