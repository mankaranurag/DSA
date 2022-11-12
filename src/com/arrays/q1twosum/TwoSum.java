package com.arrays.q1twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/two-sum/</link> LeetCode
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int nn = target - nums[i];
			if (map.containsKey(nn)) {
				return new int[] { map.get(nn), i };
			}
			map.put(nums[i], i);
		}
		return new int[] { 0, 1 };
	}
}
