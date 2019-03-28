package algorithm.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].

 Return any permutation of A that maximizes its advantage with respect to B.



 Example 1:

 Input: A = [2,7,11,15], B = [1,10,4,11]
 Output: [2,11,7,15]
 Example 2:

 Input: A = [12,24,8,32], B = [13,25,32,11]
 Output: [24,32,8,12]


 Note:

 1 <= A.length = B.length <= 10000
 0 <= A[i] <= 10^9
 0 <= B[i] <= 10^9

 * Created by huaxiufeng on 18/10/11.
 */
public class LC870AdvantageShuffle {

    /**
     * 运用田忌赛马的思路，如果A中有相应的higher元素，使用最小的higher元素。否则使用A中最小的元素 :)
     * @param A
     * @param B
     * @return
     */
    public int[] advantageCount(int[] A, int[] B) {
        if (null == A || A.length == 0 || B == null || B.length == 0 || A.length != B.length) {
            return new int[]{0};
        }
        Arrays.sort(A);
        int[] result = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            int b = B[i];
            int targetA = Integer.MIN_VALUE;
            int targetIndex = -1;
            int minA = Integer.MIN_VALUE;
            int minIndex = -1;
            for (int j = 0; j < A.length; j++) {
                if (A[j] == Integer.MIN_VALUE) {
                    continue;
                }
                if (minA == Integer.MIN_VALUE) {
                    minA = A[j];
                    minIndex = j;
                }
                if (A[j] > b) {
                    targetA = A[j];
                    targetIndex = j;
                    break;
                }
            }
            if (targetIndex > 0) {
                A[targetIndex] = Integer.MIN_VALUE;
                result[i] = targetA;
            } else {
                A[minIndex] = Integer.MIN_VALUE;
                result[i] = minA;
            }
        }
        return result;
    }

    public int[] advantageCountBruteForce(int[] A, int[] B) {
        if (null == A || A.length == 0 || B == null || B.length == 0 || A.length != B.length) {
            return new int[]{0};
        }
        int[] res = new int[A.length];
        int advantage = 0;
        List<int[]> perms = permutation(A);
        for (int[] perm : perms) {
            int count = 0;
            for (int i = 0; i < perm.length; i++) {
                if (perm[i] > B[i]) {
                    count++;
                }
            }
            if (count > advantage) {
                advantage = count;
                res = perm;
            }
        }
        return res;
    }

    private List<int[]> permutation(int[] a) {
        List<int[]> result = new ArrayList<>();
        doPermutation(a, 0, a.length, result);
        return result;
    }

    private void doPermutation(int[] a, int start, int end, List<int[]> result) {
        if (start == end) {
            result.add(Arrays.copyOf(a, a.length));
        }
        for (int i = start; i < end; i++) {
            swap(a, start, i);
            doPermutation(a, start + 1, end, result);
            swap(a, start, i);
        }
    }

    private void swap(int[] a, int i, int j) {
        if (a != null && a.length > 0 && i >= 0 && i < a.length && j >= 0 && j < a.length && i != j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }

    public static void main(String[] args) {
        LC870AdvantageShuffle solution = new LC870AdvantageShuffle();
        //System.out.println(Arrays.toString(solution.advantageCount(new int[]{0}, new int[]{0})));
        System.out.println(Arrays.toString(solution.advantageCount(new int[]{2,7,11,15}, new int[]{1,10,4,11})));
        System.out.println(Arrays.toString(solution.advantageCount(new int[]{12,24,8,32}, new int[]{13,25,32,11})));
        System.out.println(Arrays.toString(solution.advantageCount(new int[]{3451,9210,6762,6256,9339,306,6025,1879,3969,1818}, new int[]{3491,9014,7254,8463,754,3008,7842,404,1897,818})));
    }
}