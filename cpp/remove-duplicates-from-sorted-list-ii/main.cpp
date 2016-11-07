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

class Solution {
public:
    ListNode *deleteDuplicates(ListNode *head) {
        if (!head) {
            return head;
        }

        ListNode *begin = 0, *end = 0;
        ListNode *p0 = head, *p1 = head->next;
        while (1) {
            int curval = p0->val;
            if (!p1) {
                if (!begin) {
                    begin = p0;
                }
                if (!end) {
                    end = p0;
                    end->next = 0;
                } else {
                    end->next = p0;
                    end = p0;
                    end->next = 0;
                }
                cout<<"keep "<<curval<<endl;
                break;
            }
            if (p1->val != curval) {
                if (!begin) {
                    begin = p0;
                }
                if (!end) {
                    end = p0;
                    end->next = 0;
                }
                else {
                    end->next = p0;
                    end = p0;
                    end->next = 0;
                }
                cout<<"keep "<<curval<<endl;
                p0 = p1;
                p1 = p1->next;
            } else {
                cout<<"delete "<<curval<<endl;
                while (p1 && p1->val == curval) {
                    ListNode *tmp = p0;
                    p0 = p1;
                    p1 = p1->next;
                    delete tmp;
                }
                if (!p1) {
                    break;
                }
                p0 = p1;
                p1 = p1->next;
            } 
        }
    
        return begin;
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
    head = s.deleteDuplicates(head);
    
    DisplayList(head);
    
    return 0;
}

