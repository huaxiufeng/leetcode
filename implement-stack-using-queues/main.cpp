#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <queue>
#include <algorithm>
using namespace std;

class Stack {
public:
    Stack():
    w(0),nw(1){
    }
    void push(int x) {
        q[w].push(x);
    }
    void pop(void) {
        top();
        q[w].pop();
        swap(w,nw);
    }
    int top(void) {
        while (q[w].size() != 1) {
            q[nw].push(q[w].front());
            q[w].pop();
        }
        return q[w].front();
    }
    bool empty(void) {
        return q[0].empty()&&q[1].empty();
    }

    queue<int> q[2];
    int w;
    int nw;
};

int main() {
    Stack q;
    q.push(1);
    q.push(2);
    q.push(3);
    cout<<q.top()<<endl;
    q.pop();
    q.push(4);
    cout<<q.top()<<endl;
    q.pop();
    cout<<q.top()<<endl;
    return 0;
}

