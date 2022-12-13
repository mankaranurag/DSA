package com.arrays.q25foursum;

import java.util.*;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/4sum/</link>
 * LeetCode
 */
public class FourSum_BruteForce {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> output = new ArrayList<>();
        if (nums.length < 4) return output;
        if (nums.length == 4 && (nums[0] + nums[1] + nums[2] + nums[3] == target)) {
            long sum = (long) (nums[0] + nums[1]) + (long) (nums[2] + nums[3]);
            if (sum == target)
                output.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            return output;
        }

        Arrays.sort(nums);
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i <= nums.length - 4; i++) {
            for (int j = i + 1; j <= nums.length - 3; j++) {
                for (int k = j + 1; k <= nums.length - 2; k++) {
                    long sum = (long) (nums[i] + nums[j]) + (long) nums[k];
                    long fourthElement = (long) target - sum;
                    if (fourthElement < Integer.MIN_VALUE || fourthElement > Integer.MAX_VALUE) continue;
                    int outIndex = Arrays.binarySearch(nums, k + 1, nums.length, (int) fourthElement);
                    if (outIndex >= k + 1) {
                        String key = nums[i] + "" + nums[j] + "" + nums[k] + "" + nums[outIndex];
                        map.put(key, Arrays.asList(nums[i], nums[j], nums[k], nums[outIndex]));
                    }
                }
            }
        }
        output.addAll(map.values());
        return output;
    }
    // EDge Test Case
    // Input:
    // [1000000000,1000000000,1000000000,1000000000]
    // -294967296
    // Output:
    // []

}
