package algorithm.java;

/**
 * Created by amyhuiye on 2018/11/12.
 */
public class LC79WordSearch {

    public boolean exist(char[][] board, String word) {
        if (null == board || board.length == 0 || null == board[0] || board[0].length == 0 || null == word || 0 == word.length()) {
            return false;
        }
        int h = board.length;
        int w = board[0].length;
        boolean visited[][] = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean res = doCheck(board, word, visited, i, j, 0);
                    if (res) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean doCheck(char[][] board, String word, boolean[][] visited, int i, int j, int strIndex) {
        if (strIndex >= word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word.charAt(strIndex) != board[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean res = doCheck(board, word, visited, i - 1, j, strIndex + 1)
                || doCheck(board, word, visited, i + 1, j, strIndex + 1)
                || doCheck(board, word, visited, i, j - 1, strIndex + 1)
                || doCheck(board, word, visited, i, j + 1, strIndex + 1);
        visited[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        LC79WordSearch solution = new LC79WordSearch();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(solution.exist(board, "SEE")); // true
        System.out.println(solution.exist(board, "ABCCED")); // true
        System.out.println(solution.exist(board, "ABCB")); // false
    }
}
