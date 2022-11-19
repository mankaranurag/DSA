package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/letter-combinations-of-a-phone-number/</link>
 *         LeetCode
 */
public class LetterCombinationsOfPhoneNumber {
	private static Map<Integer, ArrayList<String>> phoneButtons = new HashMap<>();
	static {
		phoneButtons.put(2, new ArrayList<>(Arrays.asList("a", "b", "c")));
		phoneButtons.put(3, new ArrayList<>(Arrays.asList("d", "e", "f")));
		phoneButtons.put(4, new ArrayList<>(Arrays.asList("g", "h", "i")));
		phoneButtons.put(5, new ArrayList<>(Arrays.asList("j", "k", "l")));
		phoneButtons.put(6, new ArrayList<>(Arrays.asList("m", "n", "o")));
		phoneButtons.put(7, new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
		phoneButtons.put(8, new ArrayList<>(Arrays.asList("t", "u", "v")));
		phoneButtons.put(9, new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
	}

	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0)
			return new ArrayList<>();
		return letterCombinations(digits, 1);
	}

	private List<String> letterCombinations(String digits, int start) {
		if (digits.length() == start) {
			int digit = digits.charAt(start - 1) - '0';
			return new ArrayList<>(phoneButtons.get(digit));
		}
		int digit = digits.charAt(start - 1) - '0';
		return mul(phoneButtons.get(digit), letterCombinations(digits, start + 1));
	}

	private List<String> mul(List<String> list1, List<String> list2) {
		List<String> out = new ArrayList<>();
		for (String str1 : list1) {
			for (String str2 : list2) {
				out.add(str1 + str2);
			}
		}
		return out;
	}
}
