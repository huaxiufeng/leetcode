/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
    Given 1->4->3->2->5->2 and x = 3,
    return 1->2->2->4->3->5.
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
    ListNode* partition(ListNode* head, int x) {
        if (!head) {
            return head;
        }
        
        ListNode *left_head = 0, *left_tail = 0;
        ListNode *right_head = 0, *right_tail = 0;

        ListNode *p = head;
        while (p) {
            ListNode *p0 = p;
            p = p->next;
            if (p0->val < x) {
                // to left
                if (!left_head) {
                    left_head = p0;
                    left_tail = p0;
                } else {
                    left_tail->next = p0;
                    left_tail = left_tail->next;
                }
                left_tail->next = 0;
            } else {
                // to right
                if (!right_head) {
                    right_head = p0;
                    right_tail = p0;
                } else {
                    right_tail->next = p0;
                    right_tail = right_tail->next;
                }
                right_tail->next = 0;
            }
        }

        if (left_head && right_head) {
            left_tail->next = right_head;
            return left_head;
        } else {
            if (left_head) {
                return left_head;
            } else {
                return right_head;
            }
        }

        return 0;
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
    AddList(head, 4);
    AddList(head, 3);
    AddList(head, 2);
    AddList(head, 5);
    AddList(head, 2);

    DisplayList(head);

    Solution s;
    head = s.partition(head, 3);
    
    DisplayList(head);
    
    return 0;
}

