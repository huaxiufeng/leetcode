package algorithm.java;

/**
 * Created by huaxiufeng on 17/3/2.
 */
public class ReverseLinkedList {

    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode rHead = null;
        ListNode cursor = head;
        while (cursor != null) {
            ListNode cur = cursor;
            cursor = cursor.next;
            cur.next = rHead;
            rHead = cur;
        }
        return rHead;
    }

    public static void main(String[] args) {
        ListNode p = new ListNode(1);
        ListNode head = p;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(5);
        p = p.next;
        p.next = new ListNode(6);
        p = p.next;
        p.next = null;

        head = new ReverseLinkedList().reverseList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
