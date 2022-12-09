package com.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/n-queens/</link> LeetCode
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> out = new ArrayList<>();
        List<Point> queensPlaced = new ArrayList<>();
        solveNQueens(out, n, 0, queensPlaced);
        return out;
    }

    private void solveNQueens(List<List<String>> out, int n, int row, List<Point> queensPlaced) {
        if (queensPlaced.size() == n) {
            out.add(calculateSolution(queensPlaced, n));
        }
        if (row >= n) {
            return;
        }
        for (int i = 0; i < n; i++) {
            if (canAQueenBePlaced(row, i, queensPlaced)) {
                queensPlaced.add(new Point(row, i));
                solveNQueens(out, n, row + 1, queensPlaced);
                queensPlaced.remove(queensPlaced.size() - 1);
            }
        }
    }

    private boolean canAQueenBePlaced(int row, int i, List<Point> queensPlaced) {
        for (Point point : queensPlaced) {
            if (point.x == row || point.y == i)
                return false;
            if (Math.abs(row - point.x) == Math.abs(i - point.y))
                return false;
        }
        return true;
    }

    private List<String> calculateSolution(List<Point> queensPlaced, int n) {
        char[] charArray = new char[n];
        for (int i = 0; i < n; i++) {
            charArray[i] = '.';
        }

        List<String> chessBoard = new ArrayList<>();
//		System.out.println("SSS");
        for (Point point : queensPlaced) {
//			System.out.println(point.x + "  " + point.y);
            charArray[point.y] = 'Q';
            chessBoard.add(new String(charArray));
            charArray[point.y] = '.';
        }
        return chessBoard;
    }

    class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
