/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
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

        ListNode *p0 = head, *p1 = head->next;
        while (p1) {
            while (p1) {
                if (p1->val != p0->val) {
                    break;
                }
                ListNode *tmp = p1;
                p1 = p1->next;
                delete tmp;
            }
            p0->next = p1;
            p0 = p1;
            if (p0) {
                p1 = p0->next;
            }
        }

        return head;
    }
};
