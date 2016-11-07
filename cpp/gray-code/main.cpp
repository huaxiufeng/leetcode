/*
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
*/

#include <iostream>
#include <string>
#include <cmath>
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
    vector<int> grayCode(int n) {
        int graysize = pow(2,n);
        vector<int> code_list;

        for (int i = 0; i < graysize; i++) {
            int n = (i ^ i*2) / 2;
            code_list.push_back(n);
            cout<<i<<"\t"<<n<<endl;
        }

        return code_list;
    }
};

int main() {
    Solution s;
    vector<int> res = s.grayCode(3);
    display(res);
    return 0;
}

