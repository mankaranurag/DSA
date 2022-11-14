package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/subarray-sum-equals-k/</link> LeetCode
 */
public class SubarraySumEqualsK {

	public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0,1);
    int count =0;
    int sum = 0;
    for(int i=0;i<nums.length;i++){
        sum+=nums[i];
        if(map.containsKey(sum-k)){
            count+= map.get(sum-k);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }
}