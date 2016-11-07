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
    int min(int a, int b) {
        return a<b?a:b;
    }
    int max(int a, int b) {
        return a>b?a:b;
    }
    int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C-A)*(D-B);
        int area2 = (G-E)*(H-F);
        
        if (E>C||G<A||F>D||H<B) {
            return area1 + area2;
        }

        int x0 = max(A,E);
        int y0 = max(B,F);
        int x1 = min(C,G);
        int y1 = min(D,H);
        int overlap = (x1-x0)*(y1-y0);
        return area1 + area2 - overlap;
    }
};

int main() {
    Solution s;
    cout<<"Hello World"<<endl;
    return 0;
}

