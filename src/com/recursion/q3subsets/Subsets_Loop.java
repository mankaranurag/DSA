package com.recursion.q3subsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/subsets/</link> LeetCode
 */
public class Subsets_Loop {
    public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        for(int n : nums){
            int size = output.size();
            for(int i= 0; i<size; i++){
                List<Integer> subset = new ArrayList<>(output.get(i));
                subset.add(n);
                
                output.add(subset);
            }
        }
        return output;
	}
}
