package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/subsets-ii/</link> LeetCode
 */
public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		subsets(nums, 0, res, new ArrayList<>());
		return res;
	}

	private void subsets(int[] nums, int start, List<List<Integer>> res, List<Integer> list) {
		res.add(new ArrayList<>(list));
		if (start == nums.length)
			return;
		Set<Integer> set = new HashSet<>();
		for (int i = start; i < nums.length; i++) {
			if (set.add(nums[i])) {
				list.add(nums[i]);
				subsets(nums, i + 1, res, list);
				list.remove(list.size() - 1);
			}
		}
	}
}
