package com.arrays.q8majorityelement;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/majority-element/</link>
 *         LeetCode
 */
public class MajorityElement_BruteForce {
	// Time Limit Exceeds
	public int majorityElement(int[] nums) {
        int n = nums.length;
        for(int num:nums){
        	int count = 0;
        	for(int element:nums) {
        		if(num == element)
        			count++;
        		if(count > n/2) return num;
        	}
        }
        return -1;
    }
}
