package com.arrays;

import java.util.Arrays;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/squares-of-a-sorted-array/</link>
 * LeetCode
 */
public class SquaresOfSortedArray {

    public int[] sortedSquares(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int[] output = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[start]) > Math.abs(nums[end])) {
                output[i] = nums[start] * nums[start];
                start++;
            } else {
                output[i] = nums[end] * nums[end];
                end--;
            }
        }
        return output;
    }

    // Simple And Slow Solution using Arrays.sort;
    public int[] sortedSquaresUsingArraysSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
