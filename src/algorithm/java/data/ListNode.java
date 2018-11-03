package algorithm.java.data;

/**
 * Created by huaxiufeng on 18/10/8.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode head = this;
        while (head != null) {
            builder.append(head.val);
            if (head.next != null) {
                builder.append("->");
            }
            head = head.next;
        }
        return builder.toString();
    }

    public static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print("->");
            } else {
                System.out.println("");
            }
            head = head.next;
        }
    }

    public static ListNode fromVals(int... vals) {
        ListNode head = null;
        ListNode tail = null;
        for (int val : vals) {
            ListNode node = new ListNode(val);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
        }
        return head;
    }
}
