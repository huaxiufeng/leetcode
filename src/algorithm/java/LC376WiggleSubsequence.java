package algorithm.java;

/**
 A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative.
 The first difference (if one exists) may be either positive or negative.
 A sequence with fewer than two elements is trivially a wiggle sequence.

 For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative.
 In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.

 Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence.
 A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.

 * Created by huaxiufeng on 19/3/27.
 */
public class LC376WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = 1;
        down[0] = 1;

        for(int i = 1 ; i < nums.length; i++){
            if( nums[i] > nums[i-1] ){
                up[i] = down[i-1]+1;
                down[i] = down[i-1];
            }else if( nums[i] < nums[i-1]){
                down[i] = up[i-1]+1;
                up[i] = up[i-1];
            }else{
                down[i] = down[i-1];
                up[i] = up[i-1];
            }
        }

        return Math.max(down[nums.length-1], up[nums.length-1]);
    }

    public static void main(String[] args) {
        LC376WiggleSubsequence solution = new LC376WiggleSubsequence();
        System.out.println(solution.wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8})); // 7
        System.out.println(solution.wiggleMaxLength(new int[]{1,7,4,9,2,5})); // 6
        System.out.println(solution.wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9})); // 2
    }
}
