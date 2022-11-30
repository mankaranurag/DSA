package com.arrays;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/move-zeroes/</link> LeetCode
 */
public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				int temp = nums[k];
				nums[k] = nums[i];
				nums[i] = temp;
				k++;
			}
		}
	}
}
