package algorithm.java;

/**
 Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

 Example 1:
 Input: [3, 2, 1]

 Output: 1

 Explanation: The third maximum is 1.
 Example 2:
 Input: [1, 2]

 Output: 2

 Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 Example 3:
 Input: [2, 2, 3, 1]

 Output: 1

 Explanation: Note that the third maximum here means the third maximum distinct number.
 Both numbers with value 2 are both considered as second maximum.
 */
public class LC414ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        Integer first = null, second = null, third = null;
        for (int n : nums) {
            if (null == first) {
                first = n;
            } else {
                if (n > first) {
                    third = second;
                    second = first;
                    first = n;
                } else if (n < first) {
                    if (null == second) {
                        second = n;
                    } else {
                        if (n > second) {
                            third = second;
                            second = n;
                        } else if (n < second) {
                            if (null == third) {
                                third = n;
                            } else {
                                if (n > third) {
                                    third = n;
                                }
                            }
                        }
                    }
                }
            }
        }
        return third != null ? third : first;
    }

    public static void main(String[] args) {
        LC414ThirdMaximumNumber solution = new LC414ThirdMaximumNumber();
        System.out.println(solution.thirdMax(new int[]{3, 2, 1})); // 1
        System.out.println(solution.thirdMax(new int[]{1, 2})); // 2
        System.out.println(solution.thirdMax(new int[]{2, 2, 3, 1})); // 1
    }
}
