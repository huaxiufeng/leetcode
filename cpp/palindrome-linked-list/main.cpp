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


    bool isPalindrome(ListNode* head) {
        if (!head || !head->next) {
            return true;
        }

        int len = 0;
        ListNode *p = head;
        while (p) {
            p = p->next;
            len++;
        }

        int compare_len = len / 2;

        ListNode* p0 = head;
        ListNode* p1 = head;
        for (int i = 0; i < len - compare_len; i++) {
            p1 = p1->next;
        }
        p1 = reverseList(p1);

        ListNode *p1_bak = p1;
        int counter = 0;
        bool res = true;
        while (true) {
            if (p0->val != p1->val) {
                res = false;
            }
            counter++;
            if (counter >= compare_len) {
                break;
            }
            p0 = p0->next;
            p1 = p1->next;
        }
        p1 = p1_bak;
        p1 = reverseList(p1_bak);
        if (len % 2) {
            p0->next->next = p1;
        } else {
            p0->next = p1;
        }

        return res;
    }
};


int main() {
    ListNode* head = 0;
    AddList(head, 1);
    AddList(head, 2);
    AddList(head, 3);
    AddList(head, 2);
    AddList(head, 1);
    AddList(head, 4);
    AddList(head, 3);
    AddList(head, 2);
    AddList(head, 1);

    DisplayList(head);

    Solution s;
    cout<<s.isPalindrome(head)<<endl;
    
    DisplayList(head);
    
    return 0;
}

