package com.recursion.q7combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/combinations/</link> LeetCode
 */
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combinations = new ArrayList<>();
		combinations(n, k, 1, combinations, new ArrayList<>());
		return combinations;
	}

	private void combinations(int n, int k, int start, List<List<Integer>> combinations, List<Integer> list) {
		if (list.size() == k) {
			combinations.add(new ArrayList<>(list));
			return;
		}
		for (int i = start; i <= n; i++) {
			list.add(i);
			combinations(n, k, i + 1, combinations, list);
			list.remove(list.size() - 1);
		}
	}
}
