package com.arrays.q8majorityelement;

import java.util.Arrays;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/majority-element/</link> LeetCode
 */
public class MajorityElement_FastNoExtraSpace {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
