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

class Solution {
public:
    bool isHappy(int n) {
        set<int> table;
        int hn = n;
        do {
            table.insert(hn);
            if (hn == 1) {
                return true;
            }
            if (hn == 0) {
                return false;
            }

            int sum = 0;
            while (hn) {
                int m = hn % 10;
                hn = hn / 10;
                sum += m*m;
            }
            hn = sum;
        } while (table.find(hn) == table.end());

        return false;
    }
};

int main() {
    Solution s;
    cout<<s.isHappy(2)<<endl;
    return 0;
}

