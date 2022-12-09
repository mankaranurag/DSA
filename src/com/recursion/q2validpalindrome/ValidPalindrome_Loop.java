package com.recursion.q2validpalindrome;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/valid-palindrome/</link> LeetCode
 */
public class ValidPalindrome_Loop {
    public boolean isPalindrome(String s) {
        String temp = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        int left = 0, right = temp.length() - 1;
        while (left < right) {
            if (temp.charAt(left) != temp.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
