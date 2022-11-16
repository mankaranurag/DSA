package com.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/permutations-ii/</link> LeetCode
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
         List<List<Integer>> res = new ArrayList<>();
        permute(nums, 0, res);
        return res;
    }
    
    private void permute(int []nums, int j,List<List<Integer>> res){
        if(j == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int n:nums){
                list.add(n);
            }
            res.add(list);
            return;
        }
        Set<Integer> alreadyPresent = new HashSet<>();
        for(int i=j;i<nums.length;i++){
            if(alreadyPresent.add(nums[i])){
                swap(nums, i,j);
                permute(nums, j+1, res);
                swap(nums, i,j);
            }
        }
    }
    
    private void swap(int []nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
