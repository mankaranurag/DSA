package com.recursion;

import java.util.List;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/</link>
 * LeetCode
 */
public class MaxLenOfConcatStringWithUniqueChars {
    //	Test Cases <br />
//	["un","iq","ue"] <br />
//	["cha","r","act","ers"] <br />
//	["abcdefghijklmnopqrstuvwxyz"] <br />
//	["aa","bb"] <br />
//	["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"] <br />
    public int maxLength(List<String> arr) {
        if (arr.size() == 0)
            return 0;
        return maxLength(arr, 0, "");
    }

    private int maxLength(List<String> arr, int start, String concatString) {
        if (start >= arr.size()) {
            if (!containsDuplicate(concatString)) {
                return concatString.length();
            }
            return 0;
        }
        return Math.max(maxLength(arr, start + 1, concatString),
                maxLength(arr, start + 1, (concatString + arr.get(start))));
    }

    private boolean containsDuplicate(String concatString) {
        boolean[] alphabetsPresent = new boolean[26];
        for (int i = 0; i < concatString.length(); i++) {
            int val = concatString.charAt(i) - 'a';
            if (alphabetsPresent[val])
                return true;
            alphabetsPresent[val] = true;
        }
        return false;
    }
}
