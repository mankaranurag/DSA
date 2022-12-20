package com.arrays.q28jumpgame2;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/jump-game-ii/</link>
 * LeetCode
 */
public class JumpGameII_RecursionWithMemo {
    public int jump(int[] nums) {
        int[] memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = -1;
        }
        return jumps(nums, 0, memo);
    }

    private int jumps(int[] nums, int i, int[] memo) {
        int min = nums.length - 1;
        if (i >= nums.length - 1) return 0;
        if (memo[i] != -1) return memo[i];
        for (int j = nums[i]; j > 0; j--) {
            min = Math.min(min, 1 + jumps(nums, i + j, memo));
        }
        memo[i] = min;
        return memo[i];
    }
}
