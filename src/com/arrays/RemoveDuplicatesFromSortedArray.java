package com.arrays;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/remove-duplicates-from-sorted-array/</link>
 *         LeetCode
 */
public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[count - 1] != nums[i]) {
				nums[count] = nums[i];
				count++;
			}
		}
		return count;
	}
}
