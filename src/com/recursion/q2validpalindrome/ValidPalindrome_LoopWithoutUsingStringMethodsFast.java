package com.recursion.q2validpalindrome;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/valid-palindrome/</link> LeetCode
 */
public class ValidPalindrome_LoopWithoutUsingStringMethodsFast {
	public boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			char l = s.charAt(left);
			char r = s.charAt(right);
			if (!isValidChar(l)) {
				left++;
			}
			if (!isValidChar(r)) {
				right--;
			}
			if (isValidChar(r) && isValidChar(l)) {
				if (!equalChar(l, r))
					return false;
				left++;
				right--;
			}

		}
		return true;
	}

	private boolean isValidChar(char c) {
		// a-z 97 122
		// A-Z 65 90
		// 0-9 48 57
		if (c >= 48 && c <= 57) {
			return true;
		}
		if (c >= 65 && c <= 90) {
			return true;
		}
		if (c >= 97 && c <= 122) {
			return true;
		}
		return false;
	}

	private boolean equalChar(char c1, char c2) {
		// a-z 97 122
		// A-Z 65 90
		// 0-9 48 57
		if (c1 >= 65 && c1 <= 90) {
			c1 = (char) ((int) c1 - 65 + 97);
		}
		if (c2 >= 65 && c2 <= 90) {
			c2 = (char) ((int) c2 - 65 + 97);
		}
		if (c1 == c2)
			return true;
		return false;
	}
}
