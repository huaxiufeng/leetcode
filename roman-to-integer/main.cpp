#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <cstring>
using namespace std;

class Solution {
public:
    int romanToInt(string s) {
        int roman[256];
        memset(roman, 0, sizeof(roman));
        roman['I'] = 1;
        roman['V'] = 5;
        roman['X'] = 10;
        roman['L'] = 50;
        roman['C'] = 100;
        roman['D'] = 500;
        roman['M'] = 1000;
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            int v = roman[s.at(i)];
            if (!v) {
                return 0;
            }
            if (i+1<s.length()) {
                int v_ = roman[s.at(i+1)];
                if (!v_) {
                    return 0;
                }
                if (v_ > v) {
                    v = v_ - v;
                    i++;
                }
            }
            value += v;
        }
        return value;
    }
};

int main() {
    Solution s;
    cout<<"Hello World"<<endl;
    cout<<s.romanToInt("XV")<<endl;
    cout<<s.romanToInt("XVI")<<endl;
    cout<<s.romanToInt("XIV")<<endl;
    cout<<s.romanToInt("MMMCMXCIX")<<endl;
    cout<<s.romanToInt("CMXCIX")<<endl;
    cout<<s.romanToInt("XXXIX")<<endl;
    return 0;
}

