package com.arrays;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/running-sum-of-1d-array/</link>
 * LeetCode
 */
public class RunningSumOf1dArray {
    public int[] runningSum(int[] nums) {
        // int []runningSum = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
