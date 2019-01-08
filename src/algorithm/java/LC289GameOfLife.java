package algorithm.java;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * <p>
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * <p>
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
 * <p>
 * Created by amyhuiye on 2019/1/8.
 */
public class LC289GameOfLife {

    // board里面的每个int，低位保存之前的值，高位保存之后的值，计算完成后统一切换
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int columns = board[0].length;
        int[][] neighbors = new int[][]{
                {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}
        };
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int lives = 0;
                for (int[] neighbor : neighbors) {
                    int row = i + neighbor[0];
                    int column = j + neighbor[1];
                    if (row < 0 || row >= rows || column < 0 || column >= columns) {
                        continue;
                    }
                    lives += (board[row][column] & 1);
                }
                if ((board[i][j] & 1) == 1 && (lives == 2 || lives == 3)) {
                    board[i][j] = board[i][j] | 2;
                }
                if ((board[i][j] & 1) == 0 && lives == 3) {
                    board[i][j] = board[i][j] | 2;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }

    public static void main(String[] args) {
        LC289GameOfLife solution = new LC289GameOfLife();
        int[][] board = new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        // [
        // [0,0,0],
        // [1,0,1],
        // [0,1,1],
        // [0,1,0]
        // ]
        solution.gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
