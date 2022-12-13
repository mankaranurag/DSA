package com.arrays.q26findduplicatenumber;


import java.util.HashSet;
import java.util.Set;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/find-the-duplicate-number</link>
 * LeetCode
 */
public class FindDuplicateNumber_Set {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return num;
            set.add(num);
        }
        return nums[0];
    }
}
