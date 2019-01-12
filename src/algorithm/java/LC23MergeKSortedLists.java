package algorithm.java;

import java.util.Comparator;
import java.util.PriorityQueue;

import algorithm.java.data.ListNode;

/**
 * Created by huaxiufeng on 18/11/3.
 */
public class LC23MergeKSortedLists {

    /**
     * 简单版本
     * @param lists
     * @return
     */
//    public ListNode mergeKListsSimple(ListNode[] lists) {
//        if (null == lists || lists.length == 0) {
//            return null;
//        }
//        if (lists.length == 1) {
//            return lists[0];
//        }
//        ListNode resultHead = null;
//        ListNode resultTail = null;
//        while (true) {
//            int minIndex = -1;
//            ListNode minNode = null;
//            for (int i = 0; i < lists.length; i++) {
//                ListNode node = lists[i];
//                if (null == node) {
//                    continue;
//                }
//                if (null == minNode || node.val < minNode.val) {
//                    minNode = node;
//                    minIndex = i;
//                }
//            }
//            if (-1 == minIndex) {
//                break;
//            } else {
//                if (null == resultHead) {
//                    resultHead = minNode;
//                    resultTail = minNode;
//                } else {
//                    resultTail.next = minNode;
//                    resultTail = resultTail.next;
//                }
//                lists[minIndex] = lists[minIndex].next;
//                minNode.next = null;
//            }
//        }
//        return resultHead;
//    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode resultHead = null;
        ListNode resultTail = null;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(lists[o1].val, lists[o2].val);
            }
        });
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (null == node) {
                continue;
            }
            priorityQueue.add(i);
        }
        while (!priorityQueue.isEmpty()) {
            int minIndex = priorityQueue.poll();
            ListNode minNode = lists[minIndex];
            lists[minIndex] = lists[minIndex].next;
            if (lists[minIndex] != null) {
                priorityQueue.add(minIndex);
            }
            if (null == resultHead) {
                resultHead = minNode;
                resultTail = minNode;
            } else {
                resultTail.next = minNode;
                resultTail = resultTail.next;
            }
            minNode.next = null;
        }
        return resultHead;
    }

    public static void main(String[] args) {
        LC23MergeKSortedLists solution = new LC23MergeKSortedLists();
        ListNode result = solution.mergeKLists(new ListNode[] {
                ListNode.fromVals(1,4,5),
                ListNode.fromVals(1,3,4),
                ListNode.fromVals(2,6)
        });
        System.out.println(result.toString());
    }
}
