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
    /*
    ListNode* reverseList(ListNode* head) {
        ListNode *rhead = 0, *rtail = 0;
        ListNode *p = head;
        while (p) {
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
        return rhead;
    }
    */
    /*
    ListNode* reverseList(ListNode* head) {
        if (!head) {
            return 0;
        }
        if (head->next == 0) {
            return head;
        }

        ListNode* cur = head;
        ListNode* rrest = reverseList(head->next);
        ListNode *p = rrest;
        while (p->next) {
            p = p->next;
        }
        p->next = cur;
        cur->next = 0;
        return rrest;
    }
    */
    ListNode* reverseList(ListNode* head) {
        if (!head) {
            return 0;
        }
        if (head->next == 0) {
            return head;
        }

        ListNode *p = head;
        while (p->next->next) {
            p = p->next;
        }
        ListNode* cur = p->next;
        p->next = 0;
        cur->next = reverseList(head);
        return cur;
    }
};

int main() {
    ListNode* head = 0;
    AddList(head, 1);
    AddList(head, 1);
    AddList(head, 2);
    AddList(head, 3);
    AddList(head, 3);
    AddList(head, 4);
    AddList(head, 4);
    AddList(head, 5);
    AddList(head, 5);

    DisplayList(head);

    Solution s;
    head = s.reverseList(head);
    
    DisplayList(head);
    
    return 0;
}

