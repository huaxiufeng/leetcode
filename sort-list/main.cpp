/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
    Given 1->2->3->3->4->4->5, return 1->2->5.
    Given 1->1->1->2->3, return 2->3.
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
    ListNode* sortList(ListNode* head) {
        if (!head || head->next==0) {
            return head;
        }
        ListNode* slow = head, *fast = head->next->next;
        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
        }
        ListNode* head1 = head;
        ListNode* head2 = slow->next;
        slow->next = 0;
        head1 = sortList(head1);
        head2 = sortList(head2);
        DisplayList(head1);
        DisplayList(head2);
        return mergeList(head1, head2);
    }

    ListNode* mergeList(ListNode* la, ListNode* lb) {
        cout<<"before merge:"<<endl;
        DisplayList(la);
        DisplayList(lb);
        ListNode* head = 0;
        ListNode* tail = 0;
        while (la && lb) {
            ListNode* tmp = 0;
            if (la->val < lb->val) {
                tmp = la;
                la = la->next;
            } else {
                tmp = lb;
                lb = lb->next;
            }
            tmp->next = 0;
            if (!head) {
                head = tail = tmp;
            } else {
                tail->next = tmp;
                tail = tmp;
            }
        }
        if (la) {
            tail->next = la;
        }
        if (lb) {
            tail->next = lb;
        }
        cout<<"after merge: ";
        DisplayList(head);
        return head;
    }
};



int main() {
    ListNode* head = 0;
    AddList(head, 5);
    AddList(head, 2);
    AddList(head, 7);
    AddList(head, 4);
    AddList(head, 1);
    AddList(head, 9);
    AddList(head, 8);
    AddList(head, 3);
    AddList(head, 6);

    DisplayList(head);

    Solution s;
    head = s.sortList(head);
    
    DisplayList(head);
    
    return 0;
}

