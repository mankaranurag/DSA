package com.arrays.q13threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/3sum/</link> LeetCode
 */
public class ThreeSum_Fast {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        if (nums.length == 3) {
            if ((nums[0] + nums[1] + nums[2]) == 0)
                triplets.add(Arrays.asList(nums[0], nums[1], nums[2]));
            return triplets;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0)
                    right--;
                else if (sum < 0)
                    left++;
                else {
                    triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < nums.length - 1 && nums[left] == nums[left + 1])
                        left++;
                    while (right > 1 && nums[right] == nums[right - 1])
                        right--;
                    right--;
                    left++;
                }
            }
        }
        return triplets;
    }
}
