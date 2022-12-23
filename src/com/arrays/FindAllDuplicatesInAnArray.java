package com.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/find-all-duplicates-in-an-array/</link>
 * LeetCode
 */
public class FindAllDuplicatesInAnArray {

    // O(n) time and space complexity
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        boolean[] isPresent = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (isPresent[nums[i] - 1]) result.add(nums[i]);
            else isPresent[nums[i] - 1] = true;
        }
        return result;
    }

    // O(1) space and O(n) time complexity
    // when find a number i, flip the number at position i-1 to negative.
    // if the number at position i-1 is already negative, i is the number that occurs twice.
    public List<Integer> findDuplicatesLessSpace(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result.add(index + 1);
            }
            nums[index] = -nums[index];
        }
        return result;
    }
}
