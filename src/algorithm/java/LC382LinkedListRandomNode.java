package algorithm.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import algorithm.java.data.ListNode;

/**
 Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

 Follow up:
 What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

 http://blog.jobbole.com/42550/
 假设当前正要读取第n个数据，则我们以1/n的概率留下该数据，否则留下前n-1个数据中的一个。
 以这种方法选择，所有数据流中数据被选择的概率一样。
 简短的证明：假设n-1时候成立，即前n-1个数据被返回的概率都是1/n-1,当前正在读取第n个数据，以1/n的概率返回它。
 那么前n-1个数据中数据被返回的概率为：(1/(n-1))*((n-1)/n)= 1/n，

 * Created by huaxiufeng on 19/3/23.
 */
public class LC382LinkedListRandomNode {

    static class Solution {
        private ListNode head;
        private Random random;

        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
            this.random = new Random();
        }

        /** Returns a random node's value. */
        public int getRandom() {
            int result = head.val;
            int index = 2;
            ListNode p = head.next;
            while (p != null) {
                if (0 == random.nextInt(index)) {
                    result = p.val;
                }
                p = p.next;
                index++;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(ListNode.fromVals(1,2,3,4,5,6,7,8,9));
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            int random = solution.getRandom();
            countMap.put(random, countMap.getOrDefault(random, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
