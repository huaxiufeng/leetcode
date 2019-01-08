package algorithm.java;

import java.util.PriorityQueue;

/**
 * Created by huaxiufeng on 19/1/8.
 */
public class LC295FindMedianFromDataStream {

    public static class MedianFinder {
        private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1)); // 大顶堆
        private PriorityQueue<Integer> right = new PriorityQueue<>(); // 小顶堆

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
        }

        public void addNum(int num) {
            if (left.size() == 0) {
                left.add(num);
                return;
            }
            if (right.size() == 0) {
                if (num < left.peek()) {
                    right.add(left.poll());
                    left.add(num);
                } else {
                    right.add(num);
                }
                return;
            }
            if (left.size() > right.size()) {
                if (num >= right.peek()) {
                    right.add(num);
                } else {
                    if (num >= left.peek()) {
                        right.add(num);
                    } else {
                        right.add(left.poll());
                        left.add(num);
                    }
                }
            } else {
                if (num >= right.peek()) {
                    left.add(right.poll());
                    right.add(num);
                } else {
                    left.add(num);
                }
            }
        }

        public double findMedian() {
            if (left.size() > right.size()) {
                return left.peek();
            }
            return (left.peek() + right.peek()) / 2.0;
        }
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(40);
        medianFinder.addNum(12);
        medianFinder.addNum(16);
        medianFinder.addNum(14);
        medianFinder.addNum(35);
        medianFinder.addNum(19);
        medianFinder.addNum(34);
        medianFinder.addNum(35);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(28);
        System.out.println(medianFinder.findMedian()); // 28.0
        medianFinder.addNum(35);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(26);
        medianFinder.addNum(6);
        medianFinder.addNum(8);
        medianFinder.addNum(2);
        medianFinder.addNum(14);
        medianFinder.addNum(25);
        medianFinder.addNum(25);
        medianFinder.addNum(4);
        medianFinder.addNum(33);
    }
}
