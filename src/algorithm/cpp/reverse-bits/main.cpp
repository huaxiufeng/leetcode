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
    uint32_t reverseBits(uint32_t n) {
        uint32_t res = 0;
        int bits = sizeof(uint32_t) * 8;
        while (bits > 0) {
            res = (res<<1)|(n&0X00000001);
            n = n>>1;
            bits--;
        }
        return res;
    }
};

int main() {
    Solution s;
    cout<<s.reverseBits(43261596)<<endl;
    return 0;
}

