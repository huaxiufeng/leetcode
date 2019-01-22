package algorithm.java;

/**
 * Created by huaxiufeng on 19/1/4.
 */
public class LC221MaximalSquare {

    public int maximalSquareSlow(char[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] matrixLen = new int[matrix.length][matrix[0].length];
        int maxMatrixLen = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if ('0' == matrix[i][j]) {
                    matrixLen[i][j] = 0;
                } else {
                    matrixLen[i][j] = 1;
                    if (i >= 1 && j >= 1) {
                        int checkLen = matrixLen[i - 1][j - 1];
                        int len = 0;
                        for (int k = 0; k < checkLen + 1; k++) {
                            if (matrix[i - k][j] == '1' && matrix[i][j - k] == '1') {
                                len++;
                            } else {
                                break;
                            }
                        }
                        matrixLen[i][j] = len;
                    }
                }
                if (matrixLen[i][j] > maxMatrixLen) {
                    maxMatrixLen = matrixLen[i][j];
                }
            }
        }
        return maxMatrixLen * maxMatrixLen;
    }

    public int maximalSquare(char[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] dp = new int[height][width];
        int maxLen = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] != '1') {
                    continue;
                }
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
                maxLen = Math.max(dp[i][j], maxLen);
            }
        }
        return maxLen * maxLen;
    }

    public static void main(String[] args) {
        LC221MaximalSquare solution = new LC221MaximalSquare();
        System.out.println(solution.maximalSquare(new char[][]{
                {'0', '0', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'}
        })); // 9
        System.out.println(solution.maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        })); // 4
    }
}
