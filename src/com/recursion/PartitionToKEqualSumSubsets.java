package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/partition-to-k-equal-sum-subsets/</link>
 *         LeetCode
 */
public class PartitionToKEqualSumSubsets {
	// TODO: Unfinished
	public boolean canPartitionKSubsets(int[] nums, int k) {
		Arrays.sort(nums);
		Map<Integer, Integer> sumToCount = new HashMap<>();
		return canPartitionKSubsets(nums, k, 0, sumToCount, new ArrayList<>(), 0, 0);
	}

	private boolean canPartitionKSubsets(int[] nums, int k, int start, Map<Integer, Integer> sumToCount,
			List<Integer> list, int maxCount, int sum) {
		int count = sumToCount.getOrDefault(sum, 0) + 1;
		sumToCount.put(sum, count);
		if (count > maxCount)
			maxCount = count;
		if (maxCount == k)
			return true;
		if (nums.length == start)
			return false;

		Set<Integer> set = new HashSet<>();
		for (int i = start; i < nums.length; i++) {
			list.add(nums[i]);
			canPartitionKSubsets(nums, k, i + 1, sumToCount, list, maxCount, (sum + nums[i]));
			list.remove(list.size() - 1);
		}
		return false;
	}
}
