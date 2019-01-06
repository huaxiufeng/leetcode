package algorithm.java;

/**
 * Created by huaxiufeng on 19/1/6.
 */
public class LC240SearchA2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0, column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] > target) {
                column--;
            } else if (matrix[row][column] < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        LC240SearchA2DMatrixII solution = new LC240SearchA2DMatrixII();
        System.out.println(solution.searchMatrix(matrix, 5)); // true
        System.out.println(solution.searchMatrix(matrix, 20)); // false
    }
}
