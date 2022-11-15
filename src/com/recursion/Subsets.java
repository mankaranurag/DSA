package com.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/subsets/</link> LeetCode
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> output = new ArrayList<>();
		output.add(Collections.emptyList());
		subsets(nums, output, 0, Collections.emptyList());
		return output;

	}

	private void subsets(int[] nums,List<List<Integer>> output, int start, List<Integer> list){
        if(start == nums.length) return;
        for(int i =0 ;i<nums.length;i++) {
        	List<Integer> ls = new ArrayList<>(list);
        	ls.add(nums[i]);
        	output.add(ls);
        	subsets(nums,output, i, ls);
        }
        
    }
}
