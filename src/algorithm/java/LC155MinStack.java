package algorithm.java;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by huaxiufeng on 18/12/8.
 */
public class LC155MinStack {

    public static class MinStack {
        private List<Integer> dataList = new LinkedList<>();
        private List<Integer> minList = new LinkedList<>();

        public MinStack() {
        }

        public void push(int x) {
            dataList.add(x);
            if (x <= getMin()) {
                minList.add(x);
            }
        }

        public void pop() {
            int x = dataList.remove(dataList.size() - 1);
            if (x == getMin()) {
                minList.remove(minList.size() - 1);
            }
        }

        public int top() {
            return dataList.get(dataList.size() - 1);
        }

        public int getMin() {
            if (0 == minList.size()) {
                return Integer.MAX_VALUE;
            }
            return minList.get(minList.size() - 1);
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(3);
        System.out.println(stack.getMin()); // 2
        stack.push(1);
        System.out.println(stack.getMin()); // 1
        stack.push(5);
        stack.pop();
        System.out.println(stack.getMin()); // 1
        stack.pop();
        System.out.println(stack.getMin()); // 2
    }
}
