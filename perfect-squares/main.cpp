/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
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
/*
    int numSquares(int n) {
        vector<int> ns(n+1 , 1);
        ns[1] = 1;
        int next = 2;
        for (int i = 2; i <= n; i++) {
            if (i == next*next) {
                ns[i] = 1;
                next++;
                continue;
            }
            int begin = 1, end = i-1;
            int min_cnt = i;
            while (begin <= end && min_cnt != 2) {
                int cur_cnt = ns[begin] + ns[end];
                if (cur_cnt < min_cnt) {
                    min_cnt = cur_cnt;
                }
                begin++;
                end--;
            }
            ns[i] = min_cnt;
        }
        return ns[n];
    }
*/
    int numSquares(int n) {
        vector<int> ns(n+1 , 1);
        vector<int> s(1, 1);
        ns[1] = 1;
        int current = 1;
        int next = 2;
        for (int i = 2; i <= n; i++) {
            if (i == next*next) {
                ns[i] = 1;
                s.push_back(next*next);
                current++;
                next++;
                continue;
            }

            ns[i] = ns[i - current*current] + 1;
            for (int k = s.size()-1; k >= 0; k--) {
                int n = i / s[k];
                int m = i % s[k];
                if (n > ns[i]) {
                    break;
                }
                int cnt = n;
                if (m) {
                    cnt += ns[m];
                }
                if (cnt < ns[i]) {
                    ns[i] = cnt;
                }
            }
        }
        return ns[n];
    }

};

int main() {
    Solution s;
    cout<<s.numSquares(12)<<endl;
    cout<<s.numSquares(13)<<endl;
    cout<<s.numSquares(8829)<<endl;
    cout<<s.numSquares(9375)<<endl;
    return 0;
}

