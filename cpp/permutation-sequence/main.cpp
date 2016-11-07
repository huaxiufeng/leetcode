#include <iostream>
#include <string>
#include <cstring>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    /*
    vector<string> Perm(int n) {
        if (n == 1) {
            return vector<string>(1,"1");
        }
        vector<string> res1 = Perm(n-1);
        vector<string> res;
        char c = '0' + n;
        for (int i = 0; i < res1.size(); i++) {
            string s0 = res1[i];
            for (int k = 0; k < s0.length(); k++) {
                string s = s0.substr(0,s0.length()-k) + c + s0.substr(s0.length()-k);
                cout<<s0<<" -> "<<s<<endl;
                res.push_back(s);
            }
        }
        for (int i = 0; i < res1.size(); i++) {
            string s0 = res1[i];
            string s = c + s0;
            cout<<s0<<" -> "<<s<<endl;
            res.push_back(s);
        }
        return res;
    }

    string getPermutation(int n, int k) {
        vector<string> list = Perm(n);
        sort(list.begin(), list.end());
        string res;
        if (k >= 1 && k <= list.size()) {
            res = list[k-1];
        }
        return res; 
    }
    */

    string getPermutation(int n, int k) {
        string res;
        char num[10] = {'0'};
        for (int i = 1; i <= n; i++) {
            num[i] = i+'0';
        }
        int factorial[10] = {1};
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i-1]*i;
            cout<<"factorial "<<i<<" "<<factorial[i]<<endl;
        }
        if (k < 1) k = 1;
        if (k > factorial[n]) k = factorial[n];
        while (n > 0) {
            int index = (k-1) / factorial[n-1];
            char c = num[index+1];
            memmove(num+index+1, num+index+2, n-index-1);
            res += c;
            k = k - index*factorial[n-1];
            n--;
        }
        return res;
    }
};

int main() {
    Solution s;
    cout<<s.getPermutation(9,1)<<endl;
    return 0;
}

