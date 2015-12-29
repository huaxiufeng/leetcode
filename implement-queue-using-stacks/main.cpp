#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
using namespace std;

class Queue {
public:
    void push(int x) {
        s0.push(x);
    }
    void pop(void) {
        if (s1.size() == 0) {
            while(s0.size()) {
                int x = s0.top();
                s0.pop();
                s1.push(x);
            }
        }
        s1.pop();
    }
    int peek(void) {
        if (s1.size() == 0) {
            while(s0.size()) {
                int x = s0.top();
                s0.pop();
                s1.push(x);
            }
        }
        return s1.top();
    }
    bool empty(void) {
        return s0.empty() && s1.empty();
    }

    stack<int> s0;
    stack<int> s1;
};

int main() {
    Queue q;
    q.push(1);
    q.push(2);
    q.push(3);
    cout<<q.peek()<<endl;
    q.pop();
    q.push(4);
    cout<<q.peek()<<endl;
    q.pop();
    return 0;
}

