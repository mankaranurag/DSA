package com.recursion.q2validpalindrome;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/valid-palindrome/</link> LeetCode
 */
public class ValidPalindrome_RecursionWIthoutUsingStringMethodsFast {
	public boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		return isPalindrome(s, start, end);
	}

	private boolean isPalindrome(String s, int start, int end) {
		if (start >= end)
			return true;
		while (start < end) {
			char c = s.charAt(start);
			if (isValidChar(c)) {
				break;
			}
			start++;
		}

		while (start < end) {
			char c = s.charAt(end);
			if (isValidChar(c)) {
				break;
			}
			end--;
		}
		if (equalChar(s.charAt(start), s.charAt(end))) {
			return isPalindrome(s, start + 1, end - 1);
		}
		return false;
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
