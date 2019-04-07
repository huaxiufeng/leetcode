package algorithm.java;

/**
 * Given a non-empty integer array of size n,
 * find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing n - 1 elements by 1.
 *
 * Created by huaxiufeng on 19/4/7.
 */
public class LC453MinimumMovesToEqualArrayElements {

    /**
     let's define sum as the sum of all the numbers, before any moves; minNum as the min number int the list; n is the length of the list;
     After, say m moves, we get all the numbers as x , and we will get the following equation
     sum + m * (n - 1) = x * n
     and actually,
     x = minNum + m
     and finally, we will get
     sum - minNum * n = m
     */
    public int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            sum += n;
            if (n < min) {
                min = n;
            }
        }
        return sum - min * nums.length;
    }

    public static void main(String[] args) {
        LC453MinimumMovesToEqualArrayElements solution = new LC453MinimumMovesToEqualArrayElements();
        System.out.println(solution.minMoves(new int[]{1,1,1})); // 0
        System.out.println(solution.minMoves(new int[]{1,2,3})); // 3, [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
        System.out.println(solution.minMoves(new int[]{1,2,4})); // 4
    }
}
