/*
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
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
    void deleteNode(ListNode* node) {
        if (node && node->next) {
            ListNode* p = node->next;
            node->val = p->val;
            node->next = p->next;
            delete p;
        }
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
    
    DisplayList(head);
    
    return 0;
}

