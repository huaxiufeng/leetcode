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
    int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }

        long long obj = x;
        long long begin = 1, end = 46341;
        while (end > begin) {
            //cout<<"b "<<begin<<" e "<<end<<endl;
            long long mid = (begin + end) / 2;
            //cout<<"mid "<<mid*mid<<" obj "<<obj<<endl;
            if (mid*mid > obj) {
                end = mid-1;
            } else if (mid*mid < obj) {
                begin = mid+1;
            } else {
                return mid;
            }
        }
        if (begin*begin > obj) {
            begin--;
        }

        return begin;
    }
};

int main() {
    Solution s;
    cout<<s.mySqrt(24)<<endl;
    cout<<s.mySqrt(25)<<endl;
    cout<<s.mySqrt(26)<<endl;
    cout<<s.mySqrt(1023)<<endl;
    cout<<s.mySqrt(1024)<<endl;
    cout<<s.mySqrt(1025)<<endl;
    cout<<s.mySqrt(2147483647)<<endl;
    return 0;
}

