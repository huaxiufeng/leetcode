#include <iostream>
#include <cstdio>
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
    string add(string num1, string num2) {
        if (num1.length() < num2.length()) {
            return add(num2, num1);
        }
        cout<<"add "<<num1<<" "<<num2<<endl;
        int n = num1.length();
        num2 = string(n-num2.length(), '0') + num2;
        
        string res;
        int carry = 0;
        for (int i = n-1; i >= 0; i--) {
            int sum = (num1.at(i)-'0') + (num2.at(i)-'0') + carry;
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            } else {
                carry  = 0;
            }
            res = (char)(sum+'0') + res;
        }
        if (carry) {
            res = "1" + res;
        }
        cout<<"add res "<<res<<endl;

        return res;
    }

    /*
    string multiply(string num1, string num2) {
        if (num1.length() < num2.length()) {
            return multiply(num2, num1);
        }
        cout<<"multiply "<<num1<<" "<<num2<<endl;

        if (num2.length() == 0) return "0";
        if (num1 == "0" || num2 == "0") return "0";
        if (num2 == "1") return num1;

        if (num1.length() == 1 && num2.length() == 1) {
            int mc = (num1.at(0)-'0') * (num2.at(0)-'0');
            char buf[8];
            sprintf(buf, "%d", mc);
            return buf;
        }

        if (num2.length() > 1) {
            string res = "0";
            for (int i = 0; i < num2.length(); i++) {
                int index = num2.length()-1-i;
                char c = num2.at(index);
                string subres = multiply(num1, string(1,c)) + string(i, '0');
                res = add(res, subres);
            }
            cout<<"multiply res "<<res<<endl;
            return res;
        }

        if (num1.length() > 1 && num2.length() == 1) {
            string res = "0";
            for (int i = 0; i < num1.length(); i++) {
                int index = num1.length()-1-i;
                char c = num1.at(index);
                string subres = multiply(string(1,c), num2) + string(i, '0');
                res = add(res, subres);
            }
            cout<<"multiply res "<<res<<endl;
            return res;
        }
    }
    */
    string multiply(string num1, string num2) {
        if (num1.length() < num2.length()) {
            return multiply(num2, num1);
        }
        cout<<"multiply "<<num1<<" "<<num2<<endl;

        if (num2.length() == 0) return "0";
        if (num1 == "0" || num2 == "0") return "0";
        if (num2 == "1") return num1;
        
        string res = "0";
        for (int i = 0; i < num2.length(); i++) {
            int index2 = num2.length()-1-i;
            char c2 = num2[index2];
            string subres = string(i,'0');
            int carry = 0;
            for (int j = 0; j < num1.length(); j++) {
                int index1 = num1.length()-1-j;
                char c1 = num1[index1];
                int m = (c1-'0') * (c2-'0') + carry;
                if (m >= 10) {
                    carry = m / 10;
                    m = m % 10;
                } else {
                    carry = 0;
                }
                subres = (char)(m+'0') + subres;
            }
            if (carry) {
                subres = (char)(carry+'0') + subres;
            }
            res = add(res, subres);
        }

        return res;
    }
};

int main() {
    Solution s;
    cout<<s.multiply("256", "127")<<endl;
    //cout<<s.multiply("256117489511377083148593685533950561400363410418754703282767252221661609163404299", "61200496111643709081218550902198211480012378840070191147459688611759881218205422431757614")<<endl;
    return 0;
}

