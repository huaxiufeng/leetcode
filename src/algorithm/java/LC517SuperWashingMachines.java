package algorithm.java;

/**
 * You have n super washing machines on a line. Initially, each washing machine has some dresses or is empty.
 * <p>
 * For each move, you could choose any m (1 ≤ m ≤ n) washing machines, and pass one dress of each washing machine to one of its adjacent washing machines at the same time .
 * <p>
 * Given an integer array representing the number of dresses in each washing machine from left to right on the line, you should find the minimum number of moves to make all the washing machines
 * have the same number of dresses. If it is not possible to do it, return -1.
 * <p>
 * Example1
 * <p>
 * Input: [1,0,5]
 * <p>
 * Output: 3
 * <p>
 * Explanation:
 * 1st move:    1     0 <-- 5    =>    1     1     4
 * 2nd move:    1 <-- 1 <-- 4    =>    2     1     3
 * 3rd move:    2     1 <-- 3    =>    2     2     2
 * <p>
 * Created by huaxiufeng on 19/1/27.
 */
public class LC517SuperWashingMachines {

    // You could consider this problem as a pipeline, and the bandwidth of pipeline is "1".
    // From the leftist machine to the right, the water flows in / out.
    // To get the balanced state, calculate how many times you need to use this pipeline.
    public int findMinMoves(int[] machines) {
        int total = 0, result = 0, n = machines.length;
        for (int d : machines) {
            total += d;
        }
        if (total == 0) {
            return 0;
        }
        if (total % n != 0) {
            return -1;
        }
        int target = total / n;

        int[] move = new int[n];
        for (int i = 0; i < n - 1; i++) {
            if (machines[i] > target) {
                move[i] += machines[i] - target;
                machines[i + 1] += machines[i] - target;
                machines[i] = target;
                result = Math.max(result, move[i]);
            } else {
                move[i + 1] = target - machines[i];
                machines[i + 1] -= target - machines[i];
                machines[i] = target;
                result = Math.max(result, move[i + 1]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LC517SuperWashingMachines solution = new LC517SuperWashingMachines();
        System.out.println(solution.findMinMoves(new int[]{1, 0, 5})); // 3
    }
}
