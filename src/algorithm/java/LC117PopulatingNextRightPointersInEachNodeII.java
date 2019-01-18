package algorithm.java;

import algorithm.java.data.TreeLinkNode;

/**
 * Created by huaxiufeng on 18/11/20.
 */
public class LC117PopulatingNextRightPointersInEachNodeII {

    public void connect(TreeLinkNode root) {
        if (null == root) {
            return;
        }
        TreeLinkNode levelStart = root;
        TreeLinkNode nextLevelStart = null;
        TreeLinkNode nextLevelEnd = null;
        while (levelStart != null) {
            TreeLinkNode cur = levelStart;
            nextLevelStart = null;
            nextLevelEnd = null;
            while (cur != null) {
                if (cur.left != null) {
                    if (nextLevelStart == null) {
                        nextLevelEnd = nextLevelStart = cur.left;
                    } else {
                        nextLevelEnd.next = cur.left;
                        nextLevelEnd = nextLevelEnd.next;
                    }
                }
                if (cur.right != null) {
                    if (nextLevelStart == null) {
                        nextLevelEnd = nextLevelStart = cur.right;
                    } else {
                        nextLevelEnd.next = cur.right;
                        nextLevelEnd = nextLevelEnd.next;
                    }
                }
                cur = cur.next;
            }
            levelStart = nextLevelStart;
        }
    }

    public static void main(String[] args) throws Exception {
        LC117PopulatingNextRightPointersInEachNodeII solution = new LC117PopulatingNextRightPointersInEachNodeII();
        solution.connect(TreeLinkNode.fromLevelSequence("[1,2,3,null,5,null,7]"));
    }
}
