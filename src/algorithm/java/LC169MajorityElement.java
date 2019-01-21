package algorithm.java;

/**
 * Created by huaxiufeng on 19/1/21.
 */
public class LC169MajorityElement {

    public int majorityElement(int[] nums) {
        Integer majority = null;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (majority == null) {
                majority = nums[i];
                count = 1;
            } else {
                if (nums[i] != majority) {
                    if (count > 1) {
                        count--;
                    } else {
                        majority = null;
                        count = 0;
                    }
                } else {
                    count++;
                }
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        LC169MajorityElement solution = new LC169MajorityElement();
        System.out.println(solution.majorityElement(new int[]{3,2,3})); // 3
        System.out.println(solution.majorityElement(new int[]{2,2,1,1,1,2,2})); // 2
    }
}
