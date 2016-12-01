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
    int addDigits(int num) {
        int res = num%9;
        if (res == 0 && num) res = 9;
        return res;
    }
};

int main() {
    Solution s;
    cout<<"Hello World"<<endl;
    return 0;
}

