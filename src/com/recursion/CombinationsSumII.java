package com.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/combination-sum-ii/</link> LeetCode
 */
public class CombinationsSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<>();
        combinationSum2(candidates, target,0, combinations, new ArrayList<>(), 0);
        return combinations;
    }
    
    private void combinationSum2(int[] candidates,int target, int start, List<List<Integer>> combinations, List<Integer> list, int sum){
        if(sum == target){
            combinations.add(new ArrayList<>(list));
            return;
        }
        if(sum > target) return;
        if(list.size() >= candidates.length) return;
        
        Set<Integer> set = new HashSet<>();
        for(int i=start;i<candidates.length;i++){
            if(sum+candidates[i] > target) return;
            if(set.add(candidates[i])){
                list.add(candidates[i]);
                combinationSum2(candidates,target,i+1,combinations, list, sum + candidates[i]);
                list.remove(list.size() - 1);   
            }
        }
    }
}
