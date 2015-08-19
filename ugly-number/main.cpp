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
    bool isUgly(int num) {
        int factor[] = {2,3,5};
        int factor_count = sizeof(factor)/sizeof(int);
        
        bool res = false;
        while (1) {
            if (num <= 0) {
                break;
            }
            if (num == 1) {
                res = true;
                break;
            }

            bool hit = false;
            for (int i = 0; i < factor_count; i++) {
                if (num%factor[i] == 0) {
                    hit = true;
                    num = num / factor[i];
                    break;
                }
            }

            if (!hit) {
                break;
            }
        }
        return res;
    }
};

int main() {
    Solution s;
    cout<<s.isUgly(6)<<endl;
    cout<<s.isUgly(14)<<endl;
    return 0;
}

