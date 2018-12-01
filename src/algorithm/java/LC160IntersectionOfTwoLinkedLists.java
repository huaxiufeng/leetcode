package algorithm.java;

import algorithm.java.data.ListNode;

/**
 * Created by huaxiufeng on 18/12/1.
 */
public class LC160IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        int lenA = 0;
        int lenB = 0;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != null) {
            lenA++;
            pA = pA.next;
        }
        while (pB != null) {
            lenB++;
            pB = pB.next;
        }
        pA = headA;
        pB = headB;
        if (lenA > lenB) {
            int lenDiff = lenA - lenB;
            while (lenDiff-- > 0) {
                pA = pA.next;
            }
        } else if (lenB > lenA) {
            int lenDiff = lenB - lenA;
            while (lenDiff-- > 0) {
                pB = pB.next;
            }
        }
        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
        }
        return pA;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = (pA != null) ? pA.next : headB;
            pB = (pB != null) ? pB.next : headA;
        }
        return pA;
    }
}
