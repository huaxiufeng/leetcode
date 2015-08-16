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
    double powEven(double x, int n) {
        double res = x;
        while (n=n>>1) {
            res = res*res;
        }
        return res;
    }

    double myPow(double x, int n) {
        if (n == 0) return 1;

        bool neg = n<0?true:false;
        if (neg) n = abs(n);
        bool overflow = false;
        if (n < 0) {
            overflow = true;
            n++;
            n = abs(n);
        }

        double res = 1;
        int cursor = 1; 
        while (n) {
            bool has_bit = n&1;
            if (has_bit) {
                res = res * powEven(x, cursor);
            }
            n=n>>1;
            cursor=cursor<<1;
        }

        if (overflow) {
            res = res*x;
        }

        if (neg) {
            res = 1.0/res;
        }

        return res;
    }
};

int main() {
    Solution s;
    cout<<s.myPow(1.00000, -2147483648)<<endl;
    cout<<s.myPow(2,11)<<endl;
    //cout<<s.myPow(5,2)<<endl;
    //cout<<s.myPow(5,-2)<<endl;
    return 0;
}

