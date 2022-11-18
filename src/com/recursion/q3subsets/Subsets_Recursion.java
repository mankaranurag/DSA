package com.recursion.q3subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/subsets/</link> LeetCode
 */
public class Subsets_Recursion {
    public List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> output = new ArrayList<>();
		subsets(nums, output, 0, new ArrayList<>());
		return output;

	}

	private void subsets(int[] nums,List<List<Integer>> output, int start, List<Integer> list){
        output.add(new ArrayList<>(list));
        if(start == nums.length) return;
        for(int i =start ;i<nums.length;i++) {
        	list.add(nums[i]);
        	subsets(nums,output, i+1, list);
			list.remove(list.size() - 1);
        }
        
    }
}
