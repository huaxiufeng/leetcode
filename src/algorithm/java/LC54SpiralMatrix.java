package algorithm.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by amyhuiye on 2018/11/8.
 */
public class LC54SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || null == matrix[0] || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int height = matrix.length;
        int width = matrix[0].length;
        int totalCount = height * width;
        List<Integer> resultList = new ArrayList<>();
        int h = 0, w = 0;
        int direction = 0; // 0右1下2左3上
        Set<Integer> visited = new HashSet<>();
        while (resultList.size() < totalCount) {
            resultList.add(matrix[h][w]);
            if (resultList.size() >= totalCount) {
                break;
            }
            visited.add(h * width + w);
            int hh = h, ww= w;
            do {
                switch (direction) {
                    case 0:
                        w++;
                        break;
                    case 1:
                        h++;
                        break;
                    case 2:
                        w--;
                        break;
                    case 3:
                        h--;
                        break;
                }
                boolean valid = h >= 0 && h < height && w >= 0 && w < width && !visited.contains(h * width + w);
                if (valid) {
                    break;
                } else {
                    direction = (direction + 1) % 4;
                    h = hh;
                    w = ww;
                }
            } while (true);
        }
        return resultList;
    }

    public static void main(String[] args) {
        LC54SpiralMatrix solution = new LC54SpiralMatrix();
        List<Integer> resultList = solution.spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        System.out.println(resultList);
    }
}
