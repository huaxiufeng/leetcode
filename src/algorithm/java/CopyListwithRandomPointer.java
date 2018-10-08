package algorithm.java;

import java.util.HashMap;
import java.util.Map;

import algorithm.java.data.RandomListNode;

/**
 * Created by huaxiufeng on 18/10/8.
 */
public class CopyListwithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (null == head) {
            return null;
        }
        Map<RandomListNode, RandomListNode> nodeMap = new HashMap<>();
        RandomListNode copiedHead = new RandomListNode(0);
        RandomListNode copiedTail = copiedHead;
        while (head != null) {
            RandomListNode node;
            if (nodeMap.containsKey(head)) {
                node = nodeMap.get(head);
            } else {
                node = new RandomListNode(head.label);
                nodeMap.put(head, node);
            }
            if (head.random != null) {
                RandomListNode randomNode;
                if (nodeMap.containsKey(head.random)) {
                    randomNode = nodeMap.get(head.random);
                } else {
                    randomNode = new RandomListNode(head.random.label);
                    nodeMap.put(head.random, randomNode);
                }
                node.random = randomNode;
            }
            copiedTail.next = node;
            copiedTail = copiedTail.next;
            head = head.next;
        }
        return copiedHead.next;
    }

    public static void main(String[] args) {
        CopyListwithRandomPointer solution = new CopyListwithRandomPointer();
        RandomListNode head = new RandomListNode(1);
        RandomListNode tail = new RandomListNode(2);
        head.random = tail;
        tail.random = head;
        head.next = tail;
        solution.copyRandomList(head);
    }
}
