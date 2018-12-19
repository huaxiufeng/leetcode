package algorithm.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by amyhuiye on 2018/12/20.
 */
public class LC37SudokuSolver {

    public void solveSudoku(char[][] board) {
        Set<Integer>[][] candidateBoard = new Set[board.length][board[0].length];
        int unknownCount = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    candidateBoard[i][j] = getCandidateValues(i, j, board);
                    unknownCount++;
                }
            }
        }
        resolve(candidateBoard, board, unknownCount);
    }

    private boolean resolve(Set<Integer>[][] candidateBoard, char[][] board, int unknownCount) {
        if (0 == unknownCount) {
            return true;
        }
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (null == candidateBoard[y][x]) {
                    continue;
                }
                if (candidateBoard[y][x].size() == 0) {
                    return false;
                }
                Set<Integer> candidates = candidateBoard[y][x];
                candidateBoard[y][x] = null;
                for (int value : candidates) {
                    board[y][x] = (char)(value + '0');

                    List<Integer> removedPosList = new ArrayList<>();
                    for (int i = 0; i < 9; i++) {
                        if (candidateBoard[y][i] != null && i != x) {
                            if (candidateBoard[y][i].remove(value)) {
                                removedPosList.add(y * 9 + i);
                            }
                        }
                        if (candidateBoard[i][x] != null && i != y) {
                            if (candidateBoard[i][x].remove(value)) {
                                removedPosList.add(i * 9 + x);
                            }
                        }
                    }
                    int startY = y / 3 * 3;
                    int startX = x / 3 * 3;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (candidateBoard[startY+i][startX+j] != null && startY+i != y && startX+j != x) {
                                if (candidateBoard[startY+i][startX+j].remove(value)) {
                                    removedPosList.add((startY + i) * 9 + startX + j);
                                }
                            }
                        }
                    }

                    boolean res = resolve(candidateBoard, board, unknownCount -1);
                    if (res) {
                        return true;
                    } else {
                        board[y][x] = '.';
                        for (int removedPos : removedPosList) {
                            candidateBoard[removedPos / 9][ removedPos % 9].add(value);
                        }
                    }
                }
                candidateBoard[y][x] = candidates;
                return false;
            }
        }
        return false;
    }

    private Set<Integer> getCandidateValues(int y, int x, char[][] board) {
        if (board[y][x] != '.') {
            return null;
        }
        boolean[] occurs = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (board[y][i] != '.') {
                occurs[board[y][i] - '1'] = true;
            }
            if (board[i][x] != '.') {
                occurs[board[i][x] - '1'] = true;
            }
        }
        int startY = (y / 3) * 3;
        int startX = (x / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[startY+i][startX+j];
                if (c != '.') {
                    occurs[c - '1'] = true;
                }
            }
        }
        Set<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (!occurs[i]) {
                resultSet.add(i + 1);
            }
        }
        return resultSet;
    }

    public static void main(String[] args) {
        LC37SudokuSolver solution = new LC37SudokuSolver();
//        {
//            char[][] board = new char[][]{
//                    new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                    new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                    new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                    new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                    new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                    new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                    new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                    new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                    new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'},
//            };
//            solution.solveSudoku(board);
//            for (int i = 0; i < board.length; i++) {
//                for (int j = 0; j < board[0].length; j++) {
//                    System.out.print(board[i][j]);
//                }
//                System.out.print('\n');
//            }
//        }
        {
            char[][] board = new char[][]{
                    new char[]{'.','.','9','7','4','8','.','.','.'},
                    new char[]{'7','.','.','.','.','.','.','.','.'},
                    new char[]{'.','2','.','1','.','9','.','.','.'},
                    new char[]{'.','.','7','.','.','.','2','4','.'},
                    new char[]{'.','6','4','.','1','.','5','9','.'},
                    new char[]{'.','9','8','.','.','.','3','.','.'},
                    new char[]{'.','.','.','8','.','3','.','2','.'},
                    new char[]{'.','.','.','.','.','.','.','.','6'},
                    new char[]{'.','.','.','2','7','5','9','.','.'},
            };
            solution.solveSudoku(board);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.print('\n');
            }
        }
    }
}
