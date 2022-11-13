package com.arrays.q14productofarray;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/product-of-array-except-self/</link>
 *         LeetCode
 */
public class ProductOfArrayExceptItself {

	public int[] productExceptSelf(int[] nums) {
		int length = nums.length;
		int[] output = new int[length];
		output[0] = 1;
		for (int i = 1; i < length; i++) {
			output[i] = output[i - 1] * nums[i - 1];
		}
		int right = 1;
		for (int i = length - 1; i >= 0; i--) {
			output[i] = output[i] * right;
			right *= nums[i];
		}
		return output;
	}
}
