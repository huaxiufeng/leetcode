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
    ListNode* insertionSortList(ListNode* head) {
        if (!head || !(head->next)) {
            return head;
        }
        ListNode *shead = head, *stail = head;
        head = head->next;
        stail->next = NULL;
        while (head) {
            ListNode *head0 = head->next;
            if (head->val <= shead->val) {
                head->next = shead;
                shead = head;
            } else {
                ListNode *p = shead;
                while (p && p->next) {
                    if (head->val > p->val && head->val <= p->next->val) {
                        break;
                    }
                    p = p->next;
                }
                if (p->next) {
                    ListNode* p0 = p->next;
                    p->next = head;
                    head->next = p0;
                } else {
                    stail->next = head;
                    stail = stail->next;
                    stail->next = NULL;    
                }
            }
            head = head0;
        }
        return shead;
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
    head = s.insertionSortList(head);
    
    DisplayList(head);
    
    return 0;
}

