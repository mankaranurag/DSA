package com.arrays;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/game-of-life/</link> LeetCode
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = willCellLiveOrDie(temp, i, j, m, n);
            }
        }
    }

    private int willCellLiveOrDie(int[][] board, int i, int j, int m, int n) {
        int noOfNeighbours = 0;

        // up, down, left, right
        if (isCellLive(board, i - 1, j, m, n)) noOfNeighbours++;
        if (isCellLive(board, i + 1, j, m, n)) noOfNeighbours++;
        if (isCellLive(board, i, j + 1, m, n)) noOfNeighbours++;
        if (isCellLive(board, i, j - 1, m, n)) noOfNeighbours++;

        // diagonals
        if (isCellLive(board, i - 1, j + 1, m, n)) noOfNeighbours++;
        if (isCellLive(board, i - 1, j - 1, m, n)) noOfNeighbours++;
        if (isCellLive(board, i + 1, j - 1, m, n)) noOfNeighbours++;
        if (isCellLive(board, i + 1, j + 1, m, n)) noOfNeighbours++;

        if (board[i][j] == 1 && noOfNeighbours < 2) return 0;
        if (board[i][j] == 1 && (noOfNeighbours == 2 || noOfNeighbours == 3)) return 1;
        if (board[i][j] == 1 && noOfNeighbours > 3) return 0;
        if (board[i][j] == 0 && noOfNeighbours == 3) return 1;

        return 0;
    }

    private boolean isCellLive(int[][] board, int i, int j, int m, int n) {
        if (isValidCell(i, j, m, n)) {
            return board[i][j] == 1;
        }
        return false;
    }

    private boolean isValidCell(int i, int j, int m, int n) {
        return ((i >= 0 && i < m) && (j >= 0 && j < n));
    }
}
