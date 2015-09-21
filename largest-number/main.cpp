/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/

#include <cstdio>
#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

template <typename T>
void display(vector<T> array) {
    for (int i = 0; i < array.size(); i++) {
        cout<<array[i]<<" ";
    }
    cout<<endl;
}

static int cnt = 0;
class Solution {
public:
/*
    static bool udcompare(int a, int b) {
        cout<<cnt++<<"\tcompare "<<a<<" - "<<b<<endl;
        queue<int> bits_a, bits_b;
        while(a) {
            bits_a.push(a%10);
            a = a/10;
        }
        while(b) {
            bits_b.push(b%10);
            b = b/10;
        }
        int last_a = 0;
        if (a) {
            bits_a.back();
        }
        int last_b = 0;
        if (b) {
            bits_b.back();
        }
        while(bits_a.size() && bits_b.size()) {
            int fa = bits_a.front();
            int fb = bits_b.front();
            if (fa > fb) {
                return true;
            } else if (fa < fb) {
                return false;
            }
            bits_a.pop();
            bits_b.pop();
        }
        while (bits_a.size()) {
            int fa = bits_a.front();
            if (fa > last_b) {
                return true;
            }
            bits_a.pop();
        }
        while (bits_b.size()) {
            int fb = bits_b.front();
            if (fb > last_a) {
                return false;
            }
            bits_b.pop();
        }
        return true;
    }
    string largestNumber(vector<int>& nums) {
        display(nums);
        getchar();
        sort(nums.begin(), nums.end(), udcompare);
        display(nums);
        string res;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == 0 && res.length() == 0) {
                continue;
            }
            char buf[128];
            snprintf(buf, sizeof(buf), "%d", nums[i]);
            res = res + buf;
        }
        if (res.length() == 0) {
            res = "0";
        }
        return res;
    }
*/
    static bool udcompare(string a, string b) {
        cout<<"compare "<<a<<" with  "<<b<<endl;
        if (a == b) {
            return true;
        }
        string a2 = a+b;
        string b2 = b+a;
        for (int i = 0; i < a2.length(); i++) {
            if (a2[i] > b2[i]) {
                return true;
            } else if (a2[i] < b2[i]) {
                return false;
            }
        }
        return true;
    }

    string largestNumber(vector<int>& nums) {
        vector<string> strnums;
        int zerocnt = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (!nums[i]) {
                zerocnt++;
                continue;
            }
            char buf[128];
            snprintf(buf, sizeof(buf), "%d", nums[i]);
            strnums.push_back(buf);
        }
        sort(strnums.begin(), strnums.end(), udcompare);
        string res;
        for (int i = 0; i < strnums.size(); i++) {
            res += strnums[i];
            res += ",";
        }
        if (!res.length()) {
            res = "0";
        } else {
            for (int i = 0; i < zerocnt; i++) {
                res += "0";
            }
        }
        return res;
    }
};

int main() {
    //int arr[] = {121,12};
    int arr[] = {824,938,1399,5607,6973,5703,9609,4398,8247};
    //int arr[] = {0,34,3,31,5,9};
    //int arr[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    vector<int> nums(arr, arr+sizeof(arr)/sizeof(int));
    Solution s;
    //cout<<s.udcompare("3", "34");
    cout<<s.largestNumber(nums)<<endl;
    return 0;
}

