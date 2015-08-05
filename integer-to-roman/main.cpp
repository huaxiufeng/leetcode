#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <cstring>
using namespace std;

class Solution {
public:
    string intToRoman(int num) {
        string table[4000];
        table[1] = "I";
        table[2] = "II";
        table[3] = "III";
        table[4] = "IV";
        table[5] = "V";
        table[6] = "VI";
        table[7] = "VII";
        table[8] = "VIII";
        table[9] = "IX";
        for (int i = 10; i <= 90; i += 10) {
            table[i] = table[i/10];
            for (int j = 0; j < table[i].length(); j++) {
                if (table[i].at(j) == 'X') table[i].at(j) = 'C';
                if (table[i].at(j) == 'V') table[i].at(j) = 'L';
                if (table[i].at(j) == 'I') table[i].at(j) = 'X';
            }
        }
        for (int i = 100; i <= 900; i += 100) {
            table[i] = table[i/100];
            for (int j = 0; j < table[i].length(); j++) {
                if (table[i].at(j) == 'X') table[i].at(j) = 'M';
                if (table[i].at(j) == 'V') table[i].at(j) = 'D';
                if (table[i].at(j) == 'I') table[i].at(j) = 'C';
            }
        }
        for (int i = 1000; i <= 3000; i += 1000) {
            table[i] = table[i/1000];
            for (int j = 0; j < table[i].length(); j++) {
                if (table[i].at(j) == 'I') table[i].at(j) = 'M';
            }
        }

    
        string value;
        int checked = 0;
        int bits = 1;
        while (checked < num) {
            int n = num % (bits*10) - checked;
            checked += n;
            bits *= 10;
            //cout<<bits<<" "<<checked<<" "<<n<<" "<<table[n]<<endl;
            value = table[n] + value;
        }
        return value;
    }
};

int main() {
    Solution s;
    cout<<s.intToRoman(4)<<endl;
    cout<<s.intToRoman(8)<<endl;
    cout<<s.intToRoman(44)<<endl;
    cout<<s.intToRoman(88)<<endl;
    cout<<s.intToRoman(1976)<<endl;
    cout<<s.intToRoman(3999)<<endl;
    return 0;
}

