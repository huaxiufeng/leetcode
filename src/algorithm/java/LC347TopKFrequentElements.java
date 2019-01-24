package algorithm.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huaxiufeng on 19/1/24.
 */
public class LC347TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] frequency = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int n = entry.getKey();
            int count = entry.getValue();
            List<Integer> numList = frequency[count];
            if (null == numList) {
                numList = new ArrayList<>();
                frequency[count] = numList;
            }
            numList.add(n);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = frequency.length - 1; i >= 0 && result.size() < k; i--) {
            List<Integer> numList = frequency[i];
            if (numList != null) {
                result.addAll(numList);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC347TopKFrequentElements solution = new LC347TopKFrequentElements();
        System.out.println(solution.topKFrequent(new int[]{1,1,1,2,2,3}, 2)); // 1,2
        System.out.println(solution.topKFrequent(new int[]{1}, 1)); // 1
        System.out.println(solution.topKFrequent(new int[]{1,1,1,1,2,2,2,3,3,3}, 2)); // 1
    }
}
