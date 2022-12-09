package com.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/spiral-matrix/</link> LeetCode
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[][] isVisited = new boolean[m][n];
        int i = 0, j = 0;
        List<Integer> res = new ArrayList<>();
        boolean right = true, down = false, left = false, up = false;
        boolean isDirectionOfTraversalChanged = false, isContinuousChangeInDirectionOfTraversal = false;
        while (true) {
            // System.out.println(res + " i:" + i + " ,j:"+ j + " " + right + " " + down + "
            // " + left + " "+ up);
            if (right) {
                if (j >= n || isVisited[i][j]) {
                    right = false;
                    down = true;
                    i++;
                    j--;
                    if (isDirectionOfTraversalChanged)
                        isContinuousChangeInDirectionOfTraversal = true;
                    else
                        isDirectionOfTraversalChanged = true;
                } else {
                    isDirectionOfTraversalChanged = false;
                    res.add(matrix[i][j]);
                    isVisited[i][j] = true;
                    j++;
                }
            } else if (down) {
                if (i >= m || isVisited[i][j]) {
                    down = false;
                    left = true;
                    i--;
                    j--;
                    if (isDirectionOfTraversalChanged)
                        isContinuousChangeInDirectionOfTraversal = true;
                    else
                        isDirectionOfTraversalChanged = true;
                } else {
                    isDirectionOfTraversalChanged = false;
                    res.add(matrix[i][j]);
                    isVisited[i][j] = true;
                    i++;
                }
            } else if (left) {
                if (j < 0 || isVisited[i][j]) {
                    left = false;
                    up = true;
                    i--;
                    j++;
                    if (isDirectionOfTraversalChanged)
                        isContinuousChangeInDirectionOfTraversal = true;
                    else
                        isDirectionOfTraversalChanged = true;
                } else {
                    isDirectionOfTraversalChanged = false;
                    res.add(matrix[i][j]);
                    isVisited[i][j] = true;
                    j--;
                }
            } else if (up) {
                if (i < 0 || isVisited[i][j]) {
                    up = false;
                    right = true;
                    i++;
                    j++;
                    if (isDirectionOfTraversalChanged)
                        isContinuousChangeInDirectionOfTraversal = true;
                    else
                        isDirectionOfTraversalChanged = true;
                } else {
                    isDirectionOfTraversalChanged = false;
                    res.add(matrix[i][j]);
                    isVisited[i][j] = true;
                    i--;
                }
            }
            if (isDirectionOfTraversalChanged && isContinuousChangeInDirectionOfTraversal)
                break;
        }
        return res;
    }

}
