#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (!strs.size()) {
            return "";
        }
        bool keep_going = true;
        int idx = 0;
        for (int i = 0; i < strs[0].length() && keep_going; i++) {
            for (int j = 0; j < strs.size() && keep_going; j++) {
                if (strs[j].length() <= i) {
                    keep_going = false;
                    break;
                }
                if (strs[j][i] != strs[0][i]) {
                    keep_going = false;
                    break;
                }
            }
            if (keep_going) {
                idx = i + 1;
            }
        }
        return strs[0].substr(0, idx);
    }
};

int main() {
    Solution s;
    cout<<"Hello World"<<endl;
    return 0;
}

