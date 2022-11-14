package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/subarray-sum-equals-k/</link> LeetCode
 */
public class SubarraySumEqualsK_BruteForce {
  // Exceeds TimeLimit
	public int subarraySum(int[] nums, int k) {
        int []sum = new int[nums.length+1];
        sum[0]= 0;
        int count =0;
        for(int i=1;i<=nums.length;i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
        for(int start=0; start < sum.length;start++){
            for(int end= start+1; end < sum.length;end++){
                if(sum[end] - sum[start] == k)
                    count++;
            }
        }
        return count;
    }
}
