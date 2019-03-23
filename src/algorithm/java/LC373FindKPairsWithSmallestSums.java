package algorithm.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * <p>
 * Created by huaxiufeng on 19/3/23.
 */
public class LC373FindKPairsWithSmallestSums {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 ==null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k == 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Tuple> queue = new PriorityQueue<>(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                return Integer.compare(o1.getN1() + o1.getN2(), o2.getN1() + o2.getN2());
            }
        });
        k = Math.min(k, nums1.length * nums2.length);
        for (int i = 0; i < nums1.length; i++) {
            queue.offer(new Tuple(nums1[i], nums2[0], 0));
        }
        List<int[]> resultList = new ArrayList<>();
        while (k-- > 0) {
            Tuple pair = queue.poll();
            resultList.add(new int[]{pair.getN1(), pair.getN2()});
            if (pair.getIndex2() < nums2.length - 1) {
                queue.offer(new Tuple(pair.getN1(), nums2[pair.getIndex2() + 1], pair.getIndex2() + 1));
            }
        }
        return resultList;
    }

    private static class Tuple {
        private int n1;
        private int n2;
        private int index2;

        public Tuple(int n1, int n2, int index2) {
            this.n1 = n1;
            this.n2 = n2;
            this.index2 = index2;
        }

        public int getN1() {
            return n1;
        }

        public int getN2() {
            return n2;
        }

        public int getIndex2() {
            return index2;
        }
    }

    public static void main(String[] args) {
        LC373FindKPairsWithSmallestSums solution = new LC373FindKPairsWithSmallestSums();
        display(solution.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 10)); // [[1,1],[1,1],[2,1],[1,2],[1,2],[2,2],[1,3],[1,3],[2,3]]
        display(solution.kSmallestPairs(new int[]{}, new int[]{3, 5, 7, 9}, 1)); // []
        display(solution.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3)); // [[1,2],[1,4],[1,6]]
        display(solution.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2)); // [1,1],[1,1]
        display(solution.kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3)); // [1,3],[2,3]
    }

    private static void display(List<int[]> resultList) {
        System.out.print("[");
        for (int[] arr : resultList) {
            System.out.print(Arrays.toString(arr) + ", ");
        }
        System.out.println("]");
    }
}
