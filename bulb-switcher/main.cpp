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
    /*
    int bulbSwitch(int n) {
        if (n <= 0) {
            return 0;
        }
        int count = 0;
        bool *arr = new bool[n];
        for (int i = 0; i < n; i++) {
            arr[i] = true;
        }
        for (int x = 2; x <= n; x++) {
            int idx = -1;
            while (idx + x < n) {
                arr[idx+x] = !arr[idx+x];
                idx += x;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i]) {
                count++;
            }
        }
        delete []arr;
        return count;
    }
    */
    int bulbSwitch(int n) {
        return sqrt(n);
    }
};

int main() {
    Solution s;
    cout<<s.bulbSwitch(3)<<endl;
    cout<<s.bulbSwitch(4)<<endl;
    cout<<s.bulbSwitch(5)<<endl;
    cout<<s.bulbSwitch(6)<<endl;
    cout<<s.bulbSwitch(7)<<endl;
    return 0;
}

