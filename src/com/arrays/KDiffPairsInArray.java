package com.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/k-diff-pairs-in-an-array/</link> LeetCode
 */
public class KDiffPairsInArray {

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length; i++){
            if(!set.contains(nums[i])){
                int index = Arrays.binarySearch(nums, i+1, nums.length, nums[i] + k);
                if(index > i) count++;
                set.add(nums[i]);
            }

        }
        return count;
    }
}
