package com.recursion.q9combinationsIII;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/combination-sum-iii/</link> LeetCode
 */
public class CombinationsSumIII_Faster {
    // array is 1 To 9
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        combinationSum3(n,1, combinations, new ArrayList<>(), 0, k);
        return combinations;
    }
    
    private void combinationSum3(int target, int start, List<List<Integer>> combinations, List<Integer> list, int sum, int k){
        if(sum == target){
            if(list.size() == k)
                combinations.add(new ArrayList<>(list));
            return;
        }
        if(sum > target) return;
        if(list.size() > k)
            return;
        for(int i=start;i<=9 -(k-list.size())+1;i++){
            if(sum + i > target) return;
            list.add(i);
            combinationSum3(target,i+1,combinations, list, sum + i, k);
            list.remove(list.size() - 1);   
        }
    }
}
