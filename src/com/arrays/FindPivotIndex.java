package com.arrays;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/find-pivot-index/</link> LeetCode
 */
public class FindPivotIndex {
	public int pivotIndex(int[] nums) {
		int sum = 0;
		for (int num : nums)
			sum += num;
		int leftSum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (leftSum == sum - nums[i] - leftSum)
				return i;
			leftSum += nums[i];
		}
		return -1;
	}
}
