package algorithm.java;

/**
 Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

 Formally the function should:

 Return true if there exists i, j, k
 such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

 Example 1:

 Input: [1,2,3,4,5]
 Output: true
 Example 2:

 Input: [5,4,3,2,1]
 Output: false
 * Created by huaxiufeng on 19/3/26.
 */
public class LC334IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n < min) {
                min = n;
            } else if (n > min && n < secondMin) {
                secondMin = n;
            } else if (n > secondMin) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC334IncreasingTripletSubsequence solution = new LC334IncreasingTripletSubsequence();
        System.out.println(solution.increasingTriplet(new int[]{1,2,3,4,5})); // true
        System.out.println(solution.increasingTriplet(new int[]{5,4,3,2,1})); // false
    }
}
