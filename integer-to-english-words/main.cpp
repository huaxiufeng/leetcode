/*
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

For example,
    123 -> "One Hundred Twenty Three"
    12345 -> "Twelve Thousand Three Hundred Forty Five"
    1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
*/

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
    string thousandsN(int num) {
        string numTable[] = {"One", "Two", "Three", "Four", "Five",
                             "Six", "Seven", "Eight", "Nine", "Ten",
                             "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                             "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        string tyTable[] = {"Ten", "Twenty", "Thirty", "Forty", "Fifty",
                            "Sixty", "Seventy", "Eighty", "Ninety"};
        int hundred = num / 100;
        int left = num % 100;
        int ten = left / 10;
        int one = left % 10;

        string res;

        string blank = "";
        if (hundred) {
            res += (numTable[hundred-1] + " Hundred");
            blank = " ";
        }
        if (left < 20) {
            if (left > 0) {
                res += (blank + numTable[left-1]);
            }
        } else {
            if (ten) {
                res += (blank + tyTable[ten-1]);
            }
            if (one) {
                if (ten && !blank.length()) {
                    blank = " ";
                }
                res += (blank + numTable[one-1]);
            } 
        }
        return res;
    }

    string numberToWords(int num) {
        string unit[] = {"", " Thousand", " Million", " Billion"};
        vector<int> nums;
        while (num) {
            int t = num % 1000;
            num = num / 1000;
            nums.push_back(t);
        }

        string res;
        for (int i = 0; i < nums.size(); i++) {
            int v = nums[i];
            if (!v) {
                continue;
            }
            string str = thousandsN(v) + unit[i];
            if (res.length()) {
                res = str + " " + res;
            } else {
                res = str;
            }
        }
        if (!res.length()) {
            res = "Zero";
        }
        return res;
    }
};

int main() {
    Solution s;
    /*
    cout<<s.thousandsN(13)<<endl;
    cout<<s.thousandsN(123)<<endl;
    cout<<s.thousandsN(103)<<endl;
    cout<<s.thousandsN(113)<<endl;
    cout<<s.thousandsN(0)<<endl;
    cout<<s.thousandsN(3)<<endl;
    */
    cout<<s.numberToWords(21)<<endl;
    cout<<s.numberToWords(0)<<endl;
    cout<<s.numberToWords(1000000)<<endl;
    cout<<s.numberToWords(12345)<<endl;
    cout<<s.numberToWords(123456)<<endl;
    cout<<s.numberToWords(1234567)<<endl;
    cout<<s.numberToWords(12345678)<<endl;
    return 0;
}

