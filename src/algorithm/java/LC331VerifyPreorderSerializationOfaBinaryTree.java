package algorithm.java;

import java.util.List;
import java.util.Stack;

/**
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

         _9_
        /   \
       3     2
      / \   / \
    4   1  #  6
   / \ / \   / \
   # # # #   # #
 For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

 Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

 Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

 You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

 * Created by amyhuiye on 2019/3/13.
 */
public class LC331VerifyPreorderSerializationOfaBinaryTree {

    public boolean isValidSerialization(String preorder) {
        // 使用栈，从左向右扫描
        // 如果是数字，直接入栈
        // 如果是#，则看一下栈顶
        //     如果是数字的话，说明这是个左叶子点，入栈
        //     如果是#的话，说明这个是右叶子节点，则把左叶子节点和数字都pop出来，替换成一个#，继续判断
        // 最终判断栈里面是不是只有一个#
        if (preorder == null) {
            return false;
        }
        Stack<String> st = new Stack<>();
        String[] strs = preorder.split(",");
        for (String curr : strs) {
            while (curr.equals("#") && !st.isEmpty() && st.peek().equals(curr)) {
                st.pop();
                if (st.isEmpty()) {
                    return false;
                }
                st.pop();
            }
            st.push(curr);
        }
        return st.size() == 1 && st.peek().equals("#");
    }

    public boolean isValidSerialization1(String preorder) {
        if (null == preorder || 0 == preorder.length()) {
            return false;
        }
        String[] arr = preorder.split(",");
        return isValidSerialization1(arr, 0, arr.length - 1);
    }

    private boolean isValidSerialization1(String[] arr, int start, int end) {
        if (start > end) {
            return false;
        }
        if ("#".equals(arr[start])) {
            return start == end;
        }
        int nodeCount = 0;
        int leafCount = 0;
        for (String s : arr) {
            if ("#".equals(s)) {
                leafCount++;
            } else {
                nodeCount++;
            }
        }
        if (leafCount != nodeCount + 1) {
            return false;
        }
        nodeCount = 0;
        leafCount = 0;
        int index = start + 1;
        for (; index <= end; index++) {
            if ("#".equals(arr[index])) {
                leafCount++;
            } else {
                nodeCount++;
            }
            if (leafCount == nodeCount + 1) {
                break;
            }
        }
        return isValidSerialization1(arr, start + 1, index) && isValidSerialization1(arr, index + 1, end);
    }

    public static void main(String[] args) {
        LC331VerifyPreorderSerializationOfaBinaryTree solution = new LC331VerifyPreorderSerializationOfaBinaryTree();
        System.out.println(solution.isValidSerialization("9,#,92,#,#")); // true
        System.out.println(solution.isValidSerialization("1,#,#")); // true
        System.out.println(solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#")); // true
        System.out.println(solution.isValidSerialization("1,#")); // false
        System.out.println(solution.isValidSerialization("9,#,#,1")); // false
    }
}
