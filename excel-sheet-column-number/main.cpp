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
    int titleToNumber(string s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res*26 + (s[i]-'A'+1);
        }
        return res;
    }
};

int main() {
    Solution s;
    cout<<s.titleToNumber("C")<<endl;
    cout<<s.titleToNumber("Z")<<endl;
    cout<<s.titleToNumber("AB")<<endl;
    return 0;
}

