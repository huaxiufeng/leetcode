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

template <typename T>
void display(vector<vector<T>>& array) {
    for (int i = 0; i < array.size(); i++) {
        display(array[i]);
    }
}

class Solution {
public:
    string getHint(string secret, string guess) {
        int bull = 0, cow = 0;
        int len = secret.length();
        int s[10] = {0};
        int g[10] = {0};
        for (int i = 0; i < len; i++) {
            if (secret[i] == guess[i]) {
                bull++;
            }
            s[secret[i]-'0']++;
            g[guess[i]-'0']++;
        }
        for (int i = 0; i < 10; i++) {
            if (s[i] != 0 && g[i] != 0) {
                cow += min(s[i], g[i]);
            }
        }
        cow -= bull;
        char buf[128] = {0};
        sprintf(buf, "%dA%dB", bull, cow);
        return buf;
    }
};

int main() {
    Solution s;
    cout<<s.getHint("1123","0111")<<endl;
    return 0;
}

