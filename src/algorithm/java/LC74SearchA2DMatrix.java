package algorithm.java;

/**
 * Created by huaxiufeng on 19/1/8.
 */
public class LC74SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0 || null == matrix[0] || matrix[0].length == 0) {
            return false;
        }
        int begin = 0, end = matrix.length * matrix[0].length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            int row = mid / matrix[0].length;
            int column = mid % matrix[0].length;
            if (matrix[row][column] < target) {
                begin = mid + 1;
            } else if (matrix[row][column] > target) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC74SearchA2DMatrix solution = new LC74SearchA2DMatrix();
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(solution.searchMatrix(matrix, 3)); // true
        System.out.println(solution.searchMatrix(matrix, 13)); // false
    }
}
