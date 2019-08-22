package algorithm.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 Suppose you have a random list of people standing in a queue.
 Each person is described by a pair of integers (h, k),
 where h is the height of the person and k is the number of people in front of this person
 who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

 Note:
 The number of people is less than 1,100.
 */
public class LC406QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int cmp = Integer.compare(o1[0], o2[0]);
                if (cmp == 0) {
                    cmp = Integer.compare(o1[1], o2[1]);
                }
                return cmp;
            }
        });

        int n = people.length;
        ArrayList<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++)
            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});

        int[][] result = new int[people.length][2];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = -1;
            result[i][1] = -1;
        }
        int preh = 0;
        int index = 0;
        int i = 0;
        for (int[] one : people) {
            if (one[0] != preh) {
                index = 0;
                i = 0;
            }
            while (i < result.length) {
                if (result[i][0] < 0 && result[i][1] < 0) {
                    if (index++ == one[1]) {
                        result[i] = one;
                        break;
                    }
                }
                i++;
            }
            preh = one[0];
        }
        return result;
    }

    public static void main(String[] args) {
        LC406QueueReconstructionByHeight solution = new LC406QueueReconstructionByHeight();
        System.out.println(solution.reconstructQueue(new int[][]{
                {9,0},{7,0},{1,9},{3,0},{2,7},{5,3},{6,0},{3,4},{6,2},{5,2}
        })); // [[3,0],[6,0],[7,0],[5,2],[3,4],[5,3],[6,2],[2,7],[9,0],[1,9]]
        System.out.println(solution.reconstructQueue(new int[][]{
                {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}
        })); // [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
    }
}
