package com.arrays.q13threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/3sum/</link> LeetCode
 */
public class ThreeSum_BruteForce {
    // Exceeds Time Limit
    public List<List<Integer>> threeSum(int[] nums) {
        // to avoid duplicate triplets
        Arrays.sort(nums);
        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if ((nums[i] + nums[j] + nums[k]) == 0) {
                        String mapKey = nums[i] + "," + nums[j] + "," + nums[k];
                        System.out.println(mapKey);
                        map.put(mapKey, Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                    if ((nums[i] + nums[j] + nums[k]) > 0)
                        break;
                }
            }

        }

        return new ArrayList<>(map.values());
    }
}
