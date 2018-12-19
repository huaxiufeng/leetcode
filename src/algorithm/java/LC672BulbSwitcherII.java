package algorithm.java;

/**
 * There is a room with n lights which are turned on initially and 4 buttons on the wall. After performing exactly m unknown operations towards buttons, you need to return how many different kinds of status of the n lights could be.

 Suppose n lights are labeled as number [1, 2, 3 ..., n], function of these 4 buttons are given below:

 Flip all the lights.
 Flip lights with even numbers.
 Flip lights with odd numbers.
 Flip lights with (3k + 1) numbers, k = 0, 1, 2, ...
 Example 1:
 Input: n = 1, m = 1.
 Output: 2
 Explanation: Status can be: [on], [off]

 * Created by huaxiufeng on 18/12/19.
 */
public class LC672BulbSwitcherII {

    /**
     * 首先研究一下其中的操作，可以发现1 + 3 - > 2，1 + 2 - > 3， 2 + 3 - > 1。因此实际上至多只会产生如下8种可能：
     All_on, 1, 2, 3, 4, 1+4, 2+4, 3+4
     用二进制表示就是000~111的八种表示。
     要得到这八种结果需要至少三次操作，因此m >= 3，另外当n < 3 的时候显然是无法得到8中结果的，因此对于m < 3 || n < 3 的情况做一下讨论即可
     * @param n
     * @param m
     * @return
     */
    public int flipLights(int n, int m) {
        if (m == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        if (n == 2) {
            if (m == 1) {
                return 3;
            } else {
                return 4;
            }
        }
        if (m == 1) {
            return 4;
        } else if (m == 2) {
            return 7;
        }
        return 8;
    }

    public static void main(String[] args) {
        LC672BulbSwitcherII solution = new LC672BulbSwitcherII();
        System.out.println(solution.flipLights(1, 1)); // 2
        System.out.println(solution.flipLights(2, 1)); // 3
        System.out.println(solution.flipLights(3, 1)); // 4
    }
}
