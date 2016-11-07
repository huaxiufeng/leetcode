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

bool isBadVersion(int version) {
    return version > 1702766718;
}

class Solution {
public:
    int firstBadVersion(int n) {
        int begin = 1, end = n;
        int mid = 1;
        while (begin <= end) {
            mid = (end-begin) / 2 + begin;
            if (isBadVersion(mid)) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }
};

int main() {
    Solution s;
    cout<<s.firstBadVersion(2126753390)<<endl;
    cout<<s.firstBadVersion(9)<<endl;
    cout<<s.firstBadVersion(8)<<endl;
    cout<<s.firstBadVersion(1)<<endl;
    return 0;
}

