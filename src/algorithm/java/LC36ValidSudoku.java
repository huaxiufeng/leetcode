package algorithm.java;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by amyhuiye on 2018/11/4.
 */
public class LC36ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set<Character> row = new HashSet<>();
        Set<Character> col = new HashSet<>();
        Set<Character> cell = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            row.clear();
            col.clear();
            cell.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !col.add(board[j][i])) {
                    return false;
                }
                int x = j / 3 + i / 3 * 3;
                int y = j % 3 + i % 3 * 3;
                if (board[x][y] != '.' && !cell.add(board[x][y])) {
                    return false;
                }
            }
        }
        return true;
    }
}
