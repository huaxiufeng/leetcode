package algorithm.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by huaxiufeng on 19/1/23.
 */
public class LC218TheSkylineProblem {

    // 思路：记录每个建筑两边的竖线，并排序，记录最高的高度，当高度发生变化的时候记录下结果
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> verticalLines = new ArrayList<>();  // 记录每一个竖线
        for (int[] building : buildings) {
            verticalLines.add(new int[]{building[0], building[2]});  // 左边界竖线
            verticalLines.add(new int[]{building[1], -building[2]}); // 右边界竖线 为了区分 存入负值
        }

        // 把竖线进行排序，先按左边界进行排序，相等则高的在前面
        Collections.sort(verticalLines, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return Integer.compare(o1[0], o2[0]);
                } else {
                    return Integer.compare(o2[1], o1[1]);
                }
            }
        });

        // 大顶堆，保存高度，每次peek取最大的值
        PriorityQueue<Integer> maxHeightHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        maxHeightHeap.offer(0); // 当没有建筑的时候，高度为0
        int preMaxHeight = 0;
        List<int[]> result = new ArrayList<>();
        for (int[] verticalLine : verticalLines) {
            if (verticalLine[1] > 0) {  // 左边界
                maxHeightHeap.offer(verticalLine[1]);  //高度入队
            } else { // 右边界
                maxHeightHeap.remove(-verticalLine[1]);  // 将对应的高度从堆中删除 这里就是右边存负值的方便之处
            }
            int curMaxHeight = maxHeightHeap.peek(); // 当前最高的
            if (curMaxHeight != preMaxHeight) {  // 与上一个最高的不相等
                result.add(new int[]{verticalLine[0], curMaxHeight});
                preMaxHeight = curMaxHeight;  // 保存当前高度为下一次的前面高度
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC218TheSkylineProblem solution = new LC218TheSkylineProblem();

        int[][] buildings1 = new int[][]{
                {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}
        };
        for (int[] point : solution.getSkyline(buildings1)) {
            System.out.print(Arrays.toString(point) + " ");
        } // [ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]
        System.out.println("");

        int[][] buildings2 = new int[][]{
                {0, 2, 3}, {2, 5, 3}
        };
        for (int[] point : solution.getSkyline(buildings2)) {
            System.out.print(Arrays.toString(point) + " ");
        } // [[0,3],[5,0]]
        System.out.println("");
    }
}
