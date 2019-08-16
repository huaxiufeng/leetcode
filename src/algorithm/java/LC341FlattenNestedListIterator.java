package algorithm.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 Given a nested list of integers, implement an iterator to flatten it.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Example 1:

 Input: [[1,1],2,[1,1]]
 Output: [1,1,2,1,1]
 Explanation: By calling next repeatedly until hasNext returns false,
 the order of elements returned by next should be: [1,1,2,1,1].
 Example 2:

 Input: [1,[4,[6]]]
 Output: [1,4,6]
 Explanation: By calling next repeatedly until hasNext returns false,
 the order of elements returned by next should be: [1,4,6].
 */
public class LC341FlattenNestedListIterator {

    private static void foo(NestedIterator iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "->");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        foo(new NestedIterator(NestedInteger.instanceOf("[2,3]").getList()));
        foo(new NestedIterator(NestedInteger.instanceOf("[1,[4,[6]],[2,3]]").getList()));
    }
}

class NestedInteger {
    private Integer n;
    private List<NestedInteger> list;

    public static NestedInteger instanceOf(String value) {
        if (value.charAt(value.length() - 1) == ',') {
            value = value.substring(0, value.length() - 1);
        }
        NestedInteger ni = new NestedInteger();
        if (value.charAt(0) == '[') {
            Stack<String> stack = new Stack<>();
            stack.push("");
            int left = 0, right = 0;
            for (int i = 1; i < value.length() - 1; i++) {
                char c = value.charAt(i);
                if (c == '[') {
                    left++;
                    if (left - right == 1) {
                        stack.push("[");
                        continue;
                    }
                } else if (c == ']') {
                    right++;
                }
                stack.push(stack.pop() + c);
            }
            ni.list = new ArrayList<>();
            while (!stack.isEmpty()) {
                ni.list.add(0, instanceOf(stack.pop()));
            }
        } else {
            if (value.indexOf(',') == -1) {
                ni.n = Integer.valueOf(value);
            } else {
                ni.list = new ArrayList<>();
                String[] strs = value.split(",");
                for (String str : strs) {
                    ni.list.add(instanceOf(str));
                }
            }
        }
        return ni;
    }

    boolean isInteger() {
        return n != null && list == null;
    }

    Integer getInteger() {
        return n;
    }

    List<NestedInteger> getList() {
        return list;
    }
}

class NestedIterator implements Iterator<Integer> {

    private List<Integer> dataList = new ArrayList<>();
    private int index = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        for (NestedInteger ni : nestedList) {
            dataList.addAll(toList(ni));
        }
    }

    private List<Integer> toList(NestedInteger ni) {
        List<Integer> list = new ArrayList<>();
        if (ni.isInteger()) {
            list.add(ni.getInteger());
        } else {
            for (NestedInteger x : ni.getList()) {
                list.addAll(toList(x));
            }
        }
        return list;
    }

    @Override
    public Integer next() {
        return dataList.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < dataList.size();
    }
}
