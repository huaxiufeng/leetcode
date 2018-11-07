package algorithm.java;

/**
 * Created by amyhuiye on 2018/11/8.
 */
public class LC59SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int h = 0, w = 0;
        int cur = 1;
        int direction = 0; // 0右1下2左3上
        while (true) {
            result[h][w] = cur++;
            if (cur > n * n) {
                break;
            }
            int hh = h, ww = w;
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
                boolean valid = h >= 0 && h < n && w >= 0 && w < n && result[h][w] == 0;
                if (valid) {
                    break;
                } else {
                    direction = (direction + 1) % 4;
                    h = hh;
                    w = ww;
                }
            } while (true);
        }
        return result;
    }

    public static void main(String[] args) {
        LC59SpiralMatrixII solution = new LC59SpiralMatrixII();
        solution.generateMatrix(3);
    }
}
