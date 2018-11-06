package algorithm.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amyhuiye on 2018/11/7.
 */
public class LC51NQueens {

    private StringBuilder builder = new StringBuilder();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> resultList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            builder.append('.');
        }
        int[] columns = new int[n];
        doPlaceQueens(resultList, columns, 0);
        return resultList;
    }

    private void doPlaceQueens(List<List<String>> resultList, int[] columns, int row) {
        int n = columns.length;
        if (row == n) {
            resultList.add(buildMatrix(columns));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(columns, row, col)) {
                columns[row] = col;
                doPlaceQueens(resultList, columns, row + 1);
                columns[row] = 0;
            }
        }
    }

    private List<String> buildMatrix(int[] columns) {
        List<String> list = new ArrayList<>(columns.length);
        for (int col : columns) {
            builder.setCharAt(col, 'Q');
            list.add(builder.toString());
            builder.setCharAt(col, '.');
        }
        return list;
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
        LC51NQueens solution = new LC51NQueens();
        List<List<String>> result = solution.solveNQueens(8);
        for (List<String> list : result) {
            for (String str : list) {
                System.out.println(str);
            }
            System.out.println("-------------------------");
        }
    }
}
