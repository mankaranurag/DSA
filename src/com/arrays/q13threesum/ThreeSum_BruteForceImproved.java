package com.arrays.q13threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/3sum/</link> LeetCode
 */
public class ThreeSum_BruteForceImproved {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 3) {
            List<List<Integer>> triplets = new ArrayList<>();
            if ((nums[0] + nums[1] + nums[2]) == 0)
                triplets.add(Arrays.asList(nums[0], nums[1], nums[2]));
            return triplets;
        }
        Arrays.sort(nums);

        // to avoid duplicate triplets
        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int elementNeeded = -(nums[i] + nums[j]);
                int k = Arrays.binarySearch(nums, j + 1, nums.length, elementNeeded);
                if (k > j) {
                    String mapKey = nums[i] + "," + nums[j] + "," + nums[k];
                    // System.out.println(mapKey);
                    map.put(mapKey, Arrays.asList(nums[i], nums[j], nums[k]));
                }

            }

        }
        return new ArrayList<>(map.values());
    }
}
