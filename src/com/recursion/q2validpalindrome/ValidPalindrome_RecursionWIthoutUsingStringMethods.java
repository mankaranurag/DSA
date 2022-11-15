package com.recursion.q2validpalindrome;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/valid-palindrome/</link> LeetCode
 */
public class ValidPalindrome_RecursionWIthoutUsingStringMethods {
	public boolean isPalindrome(String s) {
		String s2 = "";
		for (int i = 0; i < s.length(); i++) {
			if (isCharacterValid(s.charAt(i))) {
				s2 += s.charAt(i);
			}
		}
		return isPalindrome(s2, 0, s2.length() - 1);
	}

	private boolean isPalindrome(String s, int left, int right) {
		if (left >= right)
			return true;
		if (isCharacterEqual(s.charAt(left), s.charAt(right)))
			return isPalindrome(s, left + 1, right - 1);
		return false;
	}

	private boolean isCharacterValid(char a) {
		if (a >= 'A' && a <= 'Z')
			return true;
		if (a >= 'a' && a <= 'z')
			return true;
		if (a >= '0' && a <= '9')
			return true;
		return false;
	}

	private boolean isCharacterEqual(char a, char b) {
		if (a >= 'A' && a <= 'Z') {
			a = (char) ((int) a - (int) 'A' + (int) 'a');
		}
		if (b >= 'A' && b <= 'Z') {
			b = (char) ((int) b - (int) 'A' + (int) 'a');
			;
		}

		if (a >= 'a' && a <= 'z' && b >= 'a' && b <= 'z') {
			if (a == b)
				return true;
		}
		if (a >= '0' && a <= '9' && b >= '0' && b <= '9') {
			if (a == b)
				return true;
		}
		return false;
	}
}
