package com.recursion.q9combinationsIII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/combination-sum-iii/</link> LeetCode
 */
public class CombinationsSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        int []candidates = new int[]{1,2,3,4,5,6,7,8,9};
        combinationSum3(candidates, n,0, combinations, new ArrayList<>(), 0, k);
        return combinations;
    }
    
    private void combinationSum3(int[] candidates,int target, int start, List<List<Integer>> combinations, List<Integer> list, int sum, int k){
        if(sum == target){
            if(list.size() == k)
                combinations.add(new ArrayList<>(list));
            return;
        }
        if(sum > target) return;
        if(list.size() >= candidates.length) return;
        
        for(int i=start;i<candidates.length;i++){
            if(sum+candidates[i] > target) return;
            list.add(candidates[i]);
            combinationSum3(candidates,target,i+1,combinations, list, sum + candidates[i], k);
            list.remove(list.size() - 1);   
        }
    }
}
