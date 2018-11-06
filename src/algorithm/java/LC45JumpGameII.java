package algorithm.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huaxiufeng on 18/11/6.
 */
public class LC45JumpGameII {

    // solution.1 Time Limit Exceeded
//    public int jump(int[] nums) {
//        List<List<Integer>> indexPathList = new ArrayList<>();
//        List<Integer> indexPath = new ArrayList<>();
//        indexPath.add(0);
//        doJump(indexPathList, indexPath, nums, 0);
//        int minLen = nums.length;
//        for (List<Integer> path : indexPathList) {
//            if (path.size() - 1 < minLen) {
//                minLen = path.size() - 1;
//            }
//        }
//        //System.out.println(indexPathList);
//        return minLen;
//    }
//
//    private void doJump(List<List<Integer>> indexPathList, List<Integer> indexPath, int[] nums, int start) {
//        if (start >= nums.length - 1) {
//            indexPathList.add(new ArrayList<>(indexPath));
//            return;
//        }
//        for (int i = 1; i <= nums[start]; i++) {
//            indexPath.add(Math.min(start + i, nums.length - 1));
//            doJump(indexPathList, indexPath, nums, start + i);
//            indexPath.remove(indexPath.size() - 1);
//        }
//    }

    // solution.2 Time Limit Exceeded
//    private int minLen;
//
//    public int jump(int[] nums) {
//        minLen = nums.length;
//        List<Integer> indexPath = new ArrayList<>();
//        indexPath.add(0);
//        doJump(indexPath, nums, 0);
//        return minLen;
//    }
//
//    private void doJump(List<Integer> indexPath, int[] nums, int start) {
//        int curLen = indexPath.size() - 1;
//        if (curLen >= minLen) {
//            return;
//        }
//        if (start >= nums.length - 1) {
//            minLen = Math.min(minLen, curLen);
//            return;
//        }
//        for (int i = 1; i <= nums[start]; i++) {
//            int targetIndex = start + i;
//            if (0 == targetIndex) {
//                continue;
//            }
//            indexPath.add(Math.min(targetIndex, nums.length - 1));
//            doJump(indexPath, nums, targetIndex);
//            indexPath.remove(indexPath.size() - 1);
//        }
//    }

    // solution.3 Time Limit Exceeded
//    public int jump(int[] nums) {
//        int[] pathLens = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            pathLens[i] = i;
//            for (int j = 0; j < i; j++) {
//                if (i - j <= nums[j]) {
//                    pathLens[i] = Math.min(pathLens[i], pathLens[j] + 1);
//                }
//            }
//        }
//        return pathLens[nums.length - 1];
//    }

    // TODO
    public int jump(int[] nums) {
        int cnt = 0;
        int cur = 0;
        int next = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > cur) {
                cur = next;
                cnt++;
            }
            next = Math.max(next, nums[i] + i);
        }
        return cnt;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        LC45JumpGameII solution = new LC45JumpGameII();
        System.out.println(solution.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println("cost " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
