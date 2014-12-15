/*
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 *  
 *  Given linked list: 1->2->3->4->5, and n = 2.
 *  After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 *  Note:
 *  Given n will always be valid.
 *  Try to do this in one pass.
 */


/**
 * Definition for singly-linked list.
 */
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
 
class Solution
{
public:
    ListNode *removeNthFromEnd(ListNode *head, int n) {
        ListNode *front = head, *end = head;
        ListNode *tmp = NULL;
        int count = 0;
        while (count < n) {
            if (!front) {
                return head;
            }
            front = front->next;
            count++;
        }
        if (!front) {
            tmp = end;
            head = end->next;
        } else {
            while (front->next) {
                front = front->next;
                end = end->next;
            }
            tmp = end->next;
            end->next = end->next->next;
        }
        delete tmp;
        return head;
    }
};
