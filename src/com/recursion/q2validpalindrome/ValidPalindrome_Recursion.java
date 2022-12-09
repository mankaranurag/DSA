package com.recursion.q2validpalindrome;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/valid-palindrome/</link> LeetCode
 */
public class ValidPalindrome_Recursion {
    public boolean isPalindrome(String s) {
        String temp = s.replaceAll("[^A-Za-z0-9]", "");
        temp = temp.toLowerCase();
        return isPalindrome(temp, 0, temp.length() - 1);
    }

    private boolean isPalindrome(String s, int left, int right) {
        if (left >= right)
            return true;
        if (s.charAt(left) != s.charAt(right))
            return false;
        return isPalindrome(s, left + 1, right - 1);
    }
}
