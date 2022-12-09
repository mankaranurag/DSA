package com.arrays.q14productofarray;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/product-of-array-except-self/</link>
 * LeetCode
 */
public class ProductOfArrayExceptItself_BigONWithoutDivision {

    // Without Using Division Operation
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[][] products = new int[length][2];
        products[0][0] = nums[0];
        products[length - 1][1] = nums[length - 1];
        for (int i = 1; i < length; i++) {
            products[i][0] = nums[i] * products[i - 1][0];
            products[length - 1 - i][1] = nums[length - 1 - i] * products[length - 1 - i + 1][1];
        }
        int[] output = new int[length];
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                output[i] = products[i + 1][1];
            } else if (i == length - 1) {
                output[i] = products[i - 1][0];
            } else {
                output[i] = products[i - 1][0] * products[i + 1][1];
            }
        }
        return output;
    }
}
