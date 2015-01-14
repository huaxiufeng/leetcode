/*
   You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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

class Solution
{
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        ListNode* head = NULL;
        ListNode* tail = NULL;
        int extra = 0;

        while (l1 || l2) {
            int n1 = 0, n2 = 0, n = 0;
            if (l1) {
                n1 = l1->val;
                l1 = l1->next;
            }
            if (l2) {
                n2 = l2->val;
                l2 = l2->next;
            }
            n = n1 + n2 + extra;
            if (n >= 10) {
                n = n % 10;
                extra = 1;
            } else {
                extra = 0;
            }

            ListNode* node = new ListNode(n);
            if (!head) {
                head = node;
                tail = node;
            } else {
                tail->next = node;
                tail = tail->next;
            }
        }

        if (extra) {
            tail->next = new ListNode(extra);
        }
        return head;
    }
};
