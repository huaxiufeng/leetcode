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

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        int listlen = 0;
        ListNode *p0 = head;
        ListNode *p1 = p0;
        while (p1) {
            listlen++;
            p1 = p1->next;
        }
        p1 = p0;
        if (!listlen) {
            return head;
        }
        k = k%listlen;
        
        if (!k) {
            return head;
        }

        for (int i = 0; i < k; i++) {
            if (!p1) {
                return head;
            }
            p1 = p1->next;
        }
        if (!p1) {
            return head;
        }
        while (p1->next) {
            p0 = p0->next;
            p1 = p1->next;
        }
        p1->next = head;
        head = p0->next;
        p0->next = NULL;
        return head;
    }
};

int main() {
    Solution s;
    cout<<"Hello World"<<endl;
    return 0;
}

