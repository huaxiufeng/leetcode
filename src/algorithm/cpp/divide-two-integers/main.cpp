#include <iostream>
#include <string>
#include <vector>
using namespace std;

#define MAX_INT 2147483647

class Solution {
public:
    int divide(int dividend, int divisor) {
        if (!divisor) return (int)MAX_INT;
        if (divisor==1) return dividend;
        bool neg = false;
        if (dividend>0&&divisor<0 || dividend<0&&divisor>0) {
            neg = true;
        }
        long long udividend = dividend, udivisor = divisor;
        if (dividend < 0){
            udividend = (long long)0-dividend;
        }
        if (divisor < 0) {
            udivisor = (long long)0-divisor;
        }

        if (udividend < udivisor) return 0;
        if (!udividend) return 0;
        if (udivisor==1) {
            int res = udividend;
            if (udividend > MAX_INT) {
                res = MAX_INT;
            } 
            return neg?0-res:res;
        }
        if (udivisor==udividend) {
            return neg?-1:1;
        }
        while (udivisor&1==0 && udividend&1==0) {
            udivisor=udivisor>>1;
            udividend=udividend>>1;
        }

        int res = 0;
        do {
            if (udividend < udivisor) {
                break;
            }
            int m = 1;
            long long product = udivisor;
            while (product < udividend) {
                //cout<<"checking "<<product<<" m "<<m<<" "<<udividend<<endl;
                if (udividend-product < product) {
                    break;
                }
                product += product;
                m += m;
            }
            udividend -= product;
            res += m;
        } while (1);

        if (res > MAX_INT) {
            res = MAX_INT;
        }

        return neg?0-res:res;
    }
};

int main() {
    Solution s;
    cout<<s.divide(-2147483648, 2)<<endl;
    cout<<s.divide(-2147483648, 1)<<endl;
    cout<<s.divide(-2147483648, -1)<<endl;
    return 0;
    cout<<s.divide(-1010369383, -2147483648)<<endl;
    cout<<s.divide(17, 3)<<endl;
    cout<<s.divide(15, 3)<<endl;
    cout<<s.divide(13, 3)<<endl;
    cout<<s.divide(12, 3)<<endl;
    cout<<s.divide(2147483647, 3)<<endl;
    //cout<<s.divide(300, 3)<<endl;
    //cout<<s.divide(301, 3)<<endl;
    //cout<<s.divide(302, 3)<<endl;
    //cout<<s.divide(303, 3)<<endl;
    //cout<<s.divide(23, 3)<<endl;
    cout<<s.divide(4, 3)<<endl;
    cout<<s.divide(-4, 3)<<endl;
    cout<<s.divide(-4, -3)<<endl;
    cout<<s.divide(1024, 4)<<endl;
    return 0;
}

