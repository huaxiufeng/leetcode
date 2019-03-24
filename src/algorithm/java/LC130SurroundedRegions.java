package algorithm.java;

/**
 * Created by amyhuiye on 2018/11/28.
 */
public class LC130SurroundedRegions {

    public void solve(char[][] board) {
        if (null == board || 0 == board.length || null == board[0] || 0 == board[0].length) {
            return;
        }
        int height = board.length;
        int width = board[0].length;
        boolean[][] visited = new boolean[height][width];
        // 从左右、上下的O向中间扩散DFS，把没有被包围的O改为*，那么剩下的O就可以直接改为X了
        for (int i = 0; i < height; i++) {
            dfs(board, visited, i, 0);
            dfs(board, visited, i, width - 1);
        }
        for (int j = 0; j < width; j++) {
            dfs(board, visited, 0, j);
            dfs(board, visited, height - 1, j);
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] visited, int i, int j) {
        int height = board.length;
        int width = board[0].length;
        if (i >= 0 && i < height && j >= 0 && j < width && board[i][j] == 'O' && !visited[i][j]) {
            visited[i][j] = true;
            board[i][j] = '*';
            dfs(board, visited,i - 1, j);
            dfs(board, visited, i + 1, j);
            dfs(board, visited, i, j - 1);
            dfs(board, visited, i, j + 1);
        }
    }

    private void displayBoard(char[][] board) {
        int height = board.length;
        int width = board[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(board[i][j]);
            }
            System.out.print('\n');
        }
        System.out.print('\n');
    }

    public static void main(String[] args) {
        LC130SurroundedRegions solution = new LC130SurroundedRegions();
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solution.displayBoard(board);
        solution.solve(board);
        solution.displayBoard(board);
    }
}
