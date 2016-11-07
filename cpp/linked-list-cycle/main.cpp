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
    bool hasCycle(ListNode *head) {
        ListNode *p1 = head, *p2 = head;
        while (p1 && p2) {
            p1 = p1->next;
            p2 = p2->next;
            if (!p2) {
                break;
            }
            p2 = p2->next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }
};


int main() {
    ListNode* head = 0;
    AddList(head, 1);

    DisplayList(head);

    Solution s;
    head = s.deleteDuplicates(head);
    
    DisplayList(head);
    
    return 0;
}

