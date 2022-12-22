package com.arrays.q30maxareaofcake;

import java.util.Arrays;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/</link>
 * LeetCode
 */
public class MaximumAreaOfPieceOfCake {
    // Explanation https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/discuss/661995/Do-you-like-visual-explanation-You-got-it.-%3A-)-With-2-code-variations.
    // To maximize area of rectangle-> maximize length and breadth
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxHeight = 0;
        int maxLength = 0;
        int prev = 0;

        // Maximize height of cake
        for (int i = 0; i < horizontalCuts.length; i++) {
            int temp = horizontalCuts[i] - prev;
            if (temp > maxHeight) maxHeight = temp;
            prev = horizontalCuts[i];
        }
        // for last horizontal cuts 2 pieces added
        if (h - prev > maxHeight) maxHeight = h - prev;
        prev = 0;

        // Maximize length of cake
        for (int i = 0; i < verticalCuts.length; i++) {
            int temp = verticalCuts[i] - prev;
            if (temp > maxLength) maxLength = temp;
            prev = verticalCuts[i];
        }
        // for last vertical cuts 2 pieces added
        if (w - prev > maxLength) maxLength = w - prev;
        return (int) ((((long) maxHeight) * ((long) maxLength)) % 1000000007L);
    }
//    Edge Case
//    1000000000
//    1000000000
//    [2]
//    [2]
}
