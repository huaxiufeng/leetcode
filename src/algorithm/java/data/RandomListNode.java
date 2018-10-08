package algorithm.java.data;

/**
 * Created by huaxiufeng on 18/10/8.
 */
public class RandomListNode {
    public int label;
    public RandomListNode next, random;

    public RandomListNode(int x) {
        this.label = x;
    }

    public static void display(RandomListNode head) {
        while (head != null) {
            System.out.print(head.label);
            if (head.next != null) {
                System.out.print("->");
            } else {
                System.out.println("");
            }
            head = head.next;
        }
    }
}
