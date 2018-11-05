package algorithm.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huaxiufeng on 18/11/5.
 */
public class LC60PermutationSequence {

    public String getPermutation(int n, int k) {
        int[] caseCounts = new int[n];
        List<Integer> nums = new ArrayList<>();
        caseCounts[0] = 1;
        nums.add(1);
        for (int i = 1; i < n; i++) {
            caseCounts[i] = caseCounts[i - 1] * i;
            nums.add(i + 1);
        }
        k = k - 1;
        StringBuilder builder = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int caseCount = caseCounts[i];
            int numIndex = k / caseCount;
            builder.append(nums.get(numIndex));
            nums.remove(numIndex);
            k = k % caseCount;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        LC60PermutationSequence solution = new LC60PermutationSequence();
        System.out.println(solution.getPermutation(4, 17));
    }
}
