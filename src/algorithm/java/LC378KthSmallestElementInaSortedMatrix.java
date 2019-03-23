package algorithm.java;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 *
 * Created by huaxiufeng on 19/3/23.
 */
public class LC378KthSmallestElementInaSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> queue = new PriorityQueue<>(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                return Integer.compare(o1.getValue(), o2.getValue());
            }
        });
        int height = matrix.length;
        int width = matrix[0].length;
        for (int h = 0; h < height; h++) {
            Tuple t = new Tuple(h, 0, matrix[h][0]);
            queue.offer(t);
            display("offer", t);
        }
        while (--k > 0) {
            Tuple tuple = queue.poll();
            display("poll", tuple);
            if (tuple.getW() < width - 1) {
                Tuple t = new Tuple(tuple.h, tuple.w + 1, matrix[tuple.h][tuple.w + 1]);
                queue.offer(t);
                display("offer", t);
            }
        }
        return queue.peek().getValue();
    }

    private static class Tuple {
        private int h;
        private int w;
        private int value;

        public Tuple(int h, int w, int value) {
            this.h = h;
            this.w = w;
            this.value = value;
        }

        public int getH() {
            return h;
        }

        public int getW() {
            return w;
        }

        public int getValue() {
            return value;
        }
    }

    private void display(String action, Tuple tuple) {
        System.out.println(action + " h:" + tuple.getH() + " w:" + tuple.getW() + " value:" + tuple.getValue());
    }

    public static void main(String[] args) {
        LC378KthSmallestElementInaSortedMatrix solution = new LC378KthSmallestElementInaSortedMatrix();
        System.out.println(solution.kthSmallest(new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        }, 8)); // 13
        System.out.println("<<<<<<<<<<<<<<<<<");
        System.out.println(solution.kthSmallest(new int[][]{
                {1, 2},
                {1, 3}
        }, 2)); // 1
    }
}
