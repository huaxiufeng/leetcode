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
    int countPrimes(int n) {
        vector<int> v(n+1, 1);
        v[0] = 0;
        v[1] = 0;
        int primecount = 0;
        for (int i = 2; i < n; i++) {
            //cout<<"checking "<<i<<" "<<v[i]<<endl;
            if (!v[i]) {
                continue;
            }
            //cout<<i<<" is prime"<<endl;
            cout<<i<<" ";
            primecount++;
            int k = i + i;
            while (true) {
                if (k >= n) {
                    break;
                }
                //cout<<idx<<" is not"<<endl;
                v[k] = 0;
                k += i;
            }
        }
        return primecount;
    }
};

int main() {
    Solution s;
    int res = s.countPrimes(120);
    return 0;
}

