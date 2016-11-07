/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
*/

#include <iostream>
#include <cstdio>
#include <cmath>
#include <string>
#include <vector>
#include <map>
using namespace std;


class Solution
{
public:
    string to_string(long long n) {
        char buf[256];
        snprintf(buf, sizeof(buf), "%lld", n);
        return buf;
    }

    string fractionToDecimal(int numerator, int denominator) {
        string res;
        long long n = numerator; 
        long long d = denominator;
        n = abs(n);
        d = abs(d);
        if ((numerator<0&&denominator>0)||
            (numerator>0&&denominator<0)) {
            res = "-";
        }
        res += to_string(n/d);
        if (n%d == 0) {
            return res;
        } else {
            res += ".";
        }
        n = n % d;
        map<int, int> table; // numerator, index
        int index = 0;
        do {
            cout<<"checking "<<n<<" @ "<<index<<endl;
            table[n] = index++;
            res += to_string(n*10/d);
            n = n*10 % d;
            if (!n) {
                index = -1;
                break;
            }
        } while(table.find(n) == table.end());

        if (index >= 0) {
            index = table[n];
            cout<<"found index @ "<<index<<endl;
            int dot_pos = res.find(".");
            res.insert(dot_pos+1+index,"(");
            res += ")";
        }
        return res;
    }
};

int main() {
    Solution s;
    cout<<s.fractionToDecimal(-1,-2147483648)<<endl;
    return 0;
}

