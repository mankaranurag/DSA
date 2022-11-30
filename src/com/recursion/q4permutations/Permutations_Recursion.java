package com.recursion.q4permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/permutations/link> LeetCode
 */
public class Permutations_Recursion {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		permute(nums, res, new ArrayList<>());
		return res;
	}

	private void permute(int[] nums, List<List<Integer>> res, List<Integer> list) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<>(list));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (!list.contains(nums[i])) {
					list.add(nums[i]);
					permute(nums, res, list);
					list.remove(list.size() - 1);

				}
			}
		}
	}
}
