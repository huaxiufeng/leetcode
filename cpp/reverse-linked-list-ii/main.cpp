/*
Reverse a singly linked list.

click to show more hints.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?
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

struct ListNode {
     int val;
     ListNode *next;
     ListNode(int x) : val(x), next(NULL) {}
};

void AddList(ListNode* &head, int value)
{
    if (!head) {
        head = new ListNode(value);
    } else {
        ListNode* p = head;
        while (p->next) {
            p = p->next;
        }
        ListNode* tail = new ListNode(value);
        p->next = tail;
    }
}

void DisplayList(ListNode* head)
{
    ListNode* p = head;
    while (p) {
        cout<<p->val<<" ";
        p = p->next;
    }
    cout<<endl;
}

class Solution {
public:
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        ListNode *fhead = 0, *ftail = 0;
        ListNode *p = head;
        for (int i = 0; i < m-1; i++) {
            if (p != head) {
                ftail = ftail->next;
            } else {
                fhead = p;
                ftail = p;
            }
            p = p->next;
        }
        
        ListNode *rhead = 0, *rtail = 0;
        for (int i = 0; i < n-m+1 && p; i++) {
            ListNode *cur = p;
            p = p->next;
            if (!rtail) {
                rtail = cur;
                rhead = cur;
                rtail->next = 0;
            } else {
                cur->next = rhead;
                rhead = cur;
            }
        }

        if (ftail) {
            ftail->next = rhead;
        } else {
            fhead = rhead;
        }
        if (rtail) {
            rtail->next = p;
        }

        return fhead;
    }
};

int main() {
    ListNode* head = 0;
    AddList(head, 8);
    AddList(head, 9);
    AddList(head, 2);
    AddList(head, 3);
    AddList(head, 4);
    AddList(head, 5);
    AddList(head, 6);
    AddList(head, 7);
    AddList(head, 8);
    AddList(head, 9);
    DisplayList(head);

    Solution s;
    head = s.reverseBetween(head, 3, 5);
    
    DisplayList(head);
    
    return 0;
}

