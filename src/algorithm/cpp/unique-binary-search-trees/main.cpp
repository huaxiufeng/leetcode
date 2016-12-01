#include <iostream>
#include <string>
#include <vector>
#include <map>
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
    int numTrees0(int n, map<int,int>& table) {
        if (n <= 1) {
            return 1;
        }
        if (table.find(n) != table.end()) {
            return table[n];
        }
        int num = 0;
        for (int i = 0; i <= n-1; i++) {
            num += numTrees0(i, table)*numTrees0(n-1-i, table);
        }
        table[n] = num;
        return num;
    }

    int numTrees(int n) {
        map<int,int> table;
        return numTrees0(n, table);
    }
};

int main() {
    Solution s;
    cout<<s.numTrees(1)<<endl;
    cout<<s.numTrees(2)<<endl;
    cout<<s.numTrees(3)<<endl;
    cout<<s.numTrees(4)<<endl;
    return 0;
}

