#include <iostream>
#include <string>
#include <vector>
#include <stack>
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

};


class MinStack {
public:
    void push(int x) {
        int minval = x;
        if (minstk.size() && minstk.top() < x) {
            minval = minstk.top();
        } 
        valstk.push(x);
        minstk.push(minval);
    }

    void pop() {
        valstk.pop();
        minstk.pop();
    }

    int top() {
        return valstk.top();
    }

    int getMin() {
        return minstk.top();
    }

    stack<int> valstk;
    stack<int> minstk;
};

int main() {
    MinStack s;
    s.push(2147483646);
    s.push(2147483646);
    s.push(2147483647);
    s.top();
    s.pop();
    s.getMin();
    s.pop();
    s.getMin();
    s.pop();
    s.push(2147483647);
    s.top();
    s.getMin();
    s.push(-2147483648);
    s.top();
    s.getMin();
    s.pop();
    s.getMin();
    cout<<"Hello World"<<endl;
    return 0;
}

