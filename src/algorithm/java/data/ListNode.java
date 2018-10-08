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
}
