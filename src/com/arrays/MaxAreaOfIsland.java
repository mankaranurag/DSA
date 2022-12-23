package com.arrays;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/max-area-of-island/</link>
 * LeetCode
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int area = calculateArea(grid, i, j);
                    if (area > maxArea) maxArea = area;
                }
            }
        }
        return maxArea;
    }

    private int calculateArea(int[][] grid, int i, int j) {
        int area = 0;
        if (i < 0 || i >= grid.length) return 0;
        if (j < 0 || j >= grid[0].length) return 0;
        if (grid[i][j] == 1) {
            area = 1;
            grid[i][j] = 0;
        } else
            return 0;

        area += calculateArea(grid, i - 1, j);
        area += calculateArea(grid, i + 1, j);
        area += calculateArea(grid, i, j - 1);
        area += calculateArea(grid, i, j + 1);
        return area;
    }
}
