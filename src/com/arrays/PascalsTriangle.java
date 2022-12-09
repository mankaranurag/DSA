package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/pascals-triangle/</link> LeetCode
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalsTriangle = new ArrayList<>();
        pascalsTriangle.add(Arrays.asList(1));
        if (numRows == 1)
            return pascalsTriangle;
        pascalsTriangle.add(Arrays.asList(1, 1));
        if (numRows == 2)
            return pascalsTriangle;
        List<Integer> prevList = Arrays.asList(1, 1);
        for (int i = 3; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            int prev = 0;
            for (Integer k : prevList) {
                if (prev == 0)
                    prev = k;
                else {
                    row.add((prev + k));
                    prev = k;
                }
            }
            row.add(1);
            pascalsTriangle.add(row);
            prevList = row;
        }

        return pascalsTriangle;
    }
}
