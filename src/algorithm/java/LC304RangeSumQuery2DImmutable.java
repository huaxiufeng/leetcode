package algorithm.java;

public class LC304RangeSumQuery2DImmutable {

    public static void main(String[] args) {
        NumMatrix solution = new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        });
        System.out.println(solution.sumRegion(2, 1, 4, 3)); // 8
        System.out.println(solution.sumRegion(1, 1, 2, 2)); // 11
        System.out.println(solution.sumRegion(1, 2, 2, 4)); // 12
    }
}

class NumMatrix {
    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        sum = new int[height][width];
        for (int i = 0; i < height; i++) {
            int[] lineSum = new int[width];
            for (int j = 0; j < width; j++) {
                lineSum[j] = (j == 0 ? 0 : lineSum[j-1]) + matrix[i][j];
                sum[i][j] = (i == 0 ? 0 : sum[i-1][j]) + lineSum[j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sum == null || row1 < 0 || col1 < 0 || row2 >= sum.length || col2 >= sum[0].length || row1 > row2 || col1 > col2) {
            return 0;
        }
        return sum[row2][col2]
                + (row1 > 0 && col1 > 0 ? sum[row1-1][col1-1] : 0)
                - (col1 > 0 ? sum[row2][col1-1] : 0)
                - (row1 > 0 ? sum[row1-1][col2] : 0);
    }
}
