package algorithm.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by huaxiufeng on 19/1/26.
 */
public class LC310MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        Map<Integer, Set<Integer>> adjacents = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjacents.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            adjacents.get(edge[0]).add(edge[1]);
            adjacents.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i : adjacents.keySet()) {
            if (adjacents.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adjacents.get(i).iterator().next();
                adjacents.get(j).remove(i);
                if (adjacents.get(j).size() == 1) {
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    public static void main(String[] args) {
        LC310MinimumHeightTrees solution = new LC310MinimumHeightTrees();
        System.out.println(solution.findMinHeightTrees(4, new int[][]{
                {1, 0}, {1, 2}, {1, 3}
        })); // [1]
        System.out.println(solution.findMinHeightTrees(6, new int[][]{
                {0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}
        })); // [3, 4]
    }
}
