package algorithm.java;

import algorithm.java.data.ListNode;

public class LC237DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
