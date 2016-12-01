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
    bool isPowerOfTwo(int n) {
        bool res = false;
        if (n > 0) {
            res = !(n&(n-1));
        }
        return res;
    }
};

int main() {
    Solution s;
    cout<<"Hello World"<<endl;
    return 0;
}

