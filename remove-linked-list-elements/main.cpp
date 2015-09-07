/*
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
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

class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
        if (!head) {
            return head;
        }

        ListNode *p0 = head;
        while (p0 && p0->val == val) {
            ListNode* temp = p0;
            p0 = p0->next;
            delete temp;
        }
        if (!p0) {
            return p0;
        }
        head = p0;
        ListNode *p1 = p0->next;
        while (p1) {
            if (p1->val == val) {
                ListNode* temp = p1;
                p1 = p1->next;
                p0->next = p1;
                delete temp;
            } else {
                p0 = p1;
                p1 = p1->next;
            }
        }

        return head;
    }
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


int main() {
    ListNode* head = 0;
    AddList(head, 6);
    AddList(head, 6);
    AddList(head, 1);
    AddList(head, 2);
    AddList(head, 6);
    AddList(head, 3);
    AddList(head, 4);
    AddList(head, 5);
    AddList(head, 6);
    
    DisplayList(head);

    Solution s;
    head = s.removeElements(head, 6);
    
    DisplayList(head);
    
    return 0;
}

