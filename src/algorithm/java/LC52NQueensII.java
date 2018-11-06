package algorithm.java;

/**
 * Created by amyhuiye on 2018/11/7.
 */
public class LC52NQueensII {

    private int count = 0;

    public int totalNQueens(int n) {
        int[] columns = new int[n];
        doPlaceQueens(columns, 0);
        return count;
    }

    private void doPlaceQueens(int[] columns, int row) {
        int n = columns.length;
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(columns, row, col)) {
                columns[row] = col;
                doPlaceQueens(columns, row + 1);
                columns[row] = 0;
            }
        }
    }

    /**
     * 判断row, col的位置是否可以放置皇后
     *
     * @param columns
     * @param row
     * @param col
     * @return
     */
    private boolean isValid(int[] columns, int row, int col) {
        for (int r = 0; r < row; r++) {
            int c = columns[r];
            if (c == col) {
                return false;
            }
            if (Math.abs(c - col) == Math.abs(r - row)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC52NQueensII solution = new LC52NQueensII();
        System.out.println(solution.totalNQueens(4));
    }
}
