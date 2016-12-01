/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
*/

#include <iostream>
#include <string>
#include <vector>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if (!l1) return l2;
        if (!l2) return l1;        
        ListNode* head = NULL, *tail = NULL;
        while (l1 && l2) {
            ListNode *smaller = NULL;
            if (l1->val < l2->val) {
                smaller = l1;
                l1 = l1->next;
            } else {
                smaller = l2;
                l2 = l2->next;
            }
            if (!head) {
                head = smaller;
                tail = smaller;
            } else {
                tail->next = smaller;
                tail = tail->next;
            }
        }
        if (l1) tail->next = l1;
        if (l2) tail->next = l2;
        return head;
    }    
};

int main() {
    Solution s;
    cout<<"Hello World"<<endl;
    return 0;
}

