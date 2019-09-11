package algorithm.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huaxiufeng on 18/10/8.
 */
public class LC138CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        if (null == head) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node copiedHead = new Node(head.val);
        map.put(head, copiedHead);
        Node copiedTail = copiedHead;
        Node cursor = head.next;
        while (cursor != null) {
            copiedTail.next = new Node(cursor.val);
            copiedTail = copiedTail.next;
            map.put(cursor, copiedTail);
            cursor = cursor.next;
        }
        cursor = head;
        while (cursor != null) {
            Node copiedNode = map.get(cursor);
            if (cursor.random != null) {
                copiedNode.random = map.get(cursor.random);
            }
            cursor = cursor.next;
        }
        return copiedHead;
    }

    public static void main(String[] args) {
        LC138CopyListWithRandomPointer solution = new LC138CopyListWithRandomPointer();
        Node head = new Node(1);
        Node tail = new Node(2);
        head.random = tail;
        tail.random = head;
        head.next = tail;
        solution.copyRandomList(head);
    }

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
