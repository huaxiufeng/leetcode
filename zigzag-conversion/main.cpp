/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    string convert(string s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        vector<int> index;
        string res;
        for (int i = 0; i < s.length(); i++) {
            int f = i % (2 * (numRows-1));
            if (f > numRows - 1) {
                f = 2 * (numRows-1) - f;
            }
            index.push_back(f);
        }
        for (int n = 0; n < numRows; n++) {
            for (int i = 0; i < index.size(); i++) {
                if (index[i] == n) {
                    res += s[i];
                }
            }
        }
        return res; 
    }
};

int main() {
    cout<<Solution().convert("PAYPALISHIRING", 3)<<endl;
    cout<<"Hello World"<<endl;
    return 0;
}

