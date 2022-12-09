package com.arrays.q1twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/two-sum/</link> LeetCode
 */
public class TwoSum2 {
    public int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            memo.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (memo.containsKey(temp)) {
                int si = memo.get(temp);
                if (i != si) {
                    output[0] = i < si ? i : si;
                    output[1] = i < si ? si : i;
                }
            }

        }

        return output;
    }
}
