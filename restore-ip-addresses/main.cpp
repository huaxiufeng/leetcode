/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

template <typename T>
void display(vector<T> array) {
    for (int i = 0; i < array.size(); i++) {
        cout<<array[i]<<" "<<endl;
    }
    cout<<endl;
}

class Solution {
public:
    vector<string> restore(vector<string> collected, string leftstr) {
        vector<string> res;
        if (collected.size() == 4) {
            if (leftstr.length()) {
                return res;
            } else {
                string ip = collected[0] + "." + 
                            collected[1] + "." + 
                            collected[2] + "." + 
                            collected[3];
                res.push_back(ip);
                return res;
            }
        }

        if (leftstr.length() == 0) {
            return res;
        }

        if (leftstr[0] == '0') {
            vector<string> c = collected;
            c.push_back("0");
            return restore(c, leftstr.substr(1));
        }

        int val = 0;
        for (int i = 0; i < leftstr.length() && i < 3; i++) {
            val = val * 10 + (leftstr[i] - '0');
            if (val > 255) {
                break;
            }
            vector<string> c = collected;
            c.push_back(leftstr.substr(0, i+1));
            vector<string> resi = restore(c, leftstr.substr(i+1));
            for (int k = 0; k < resi.size(); k++) {
                res.push_back(resi[k]);
            }
        }

        return res;
    }
    vector<string> restoreIpAddresses(string s) {
        return restore(vector<string>(),s);
    }
};

int main() {
    Solution s;
    //vector<string> res = s.restoreIpAddresses("25525511135");
    vector<string> res = s.restoreIpAddresses("010010");
    display(res);
    return 0;
}

