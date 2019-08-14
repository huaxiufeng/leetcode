package algorithm.java;

/**
 You are given a doubly linked list which in addition to the next and previous pointers,
 it could have a child pointer, which may or may not point to a separate doubly linked list.
 These child lists may have one or more children of their own, and so on, to produce a multilevel data structure,
 as shown in the example below.

 Flatten the list so that all the nodes appear in a single-level, doubly linked list.
 You are given the head of the first level of the list.


 Example:

 Input:
 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL

 Output:
 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 */
public class LC430FlattenAMultilevelDoublyLinkedList {

    public Node flatten(Node head) {
        if (null == head) {
            return head;
        }
        if (head.child == null) {
            if (head.next != null) {
                Node next = flatten(head.next);
                head.next = next;
                next.prev = head;
            }
        } else {
            Node child = head.child;
            Node next = head.next;
            head.child = null;
            child = flatten(child);
            head.next = child;
            child.prev = head;
            if (next != null) {
                Node cur = head;
                while (cur.next != null) {
                    cur = cur.next;
                }
                next = flatten(next);
                cur.next = next;
                next.prev = cur;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        //  1---2---3---NULL
        //      |
        //      4---5---NULL
        //   1,2,4,5,3
        Node node1 = new Node(1, null, null, null);
        Node node2 = new Node(2, null, null, null);
        Node node3 = new Node(3, null, null, null);
        Node node4 = new Node(4, null, null, null);
        Node node5 = new Node(5, null, null, null);
        node1.next = node2;
        node2.next = node3;
        node2.child = node4;
        node2.prev = node1;
        node3.prev = node2;
        node4.next = node5;
        node5.prev = node4;
        LC430FlattenAMultilevelDoublyLinkedList solution = new LC430FlattenAMultilevelDoublyLinkedList();
        solution.flatten(node1);
        Node cur = node1;
        while (cur != null) {
            System.out.print(cur.val + "-");
            cur = cur.next;
        }
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }
}
