package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/combination-sum/</link>
 * LeetCode
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> output = new ArrayList<>();
        combinationSum(candidates, target, 0, output, new ArrayList<>());
        return output;
    }

    private void combinationSum(int[] candidates, int target, int current, List<List<Integer>> output, List<Integer> list) {
        if (current >= candidates.length) return;
        if (target == 0) {
            output.add(new ArrayList<>(list));
            return;
        }
        for (int i = current; i < candidates.length; i++) {
            if( candidates[i] <= target) {
                list.add(candidates[i]);
                combinationSum(candidates, target - candidates[i], i, output, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
