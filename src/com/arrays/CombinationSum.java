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
        combinationSum(candidates, target, 0, 0, output, new ArrayList<>());
        return output;
    }

    private void combinationSum(int[] candidates, int target, int current, int currentSum, List<List<Integer>> output, List<Integer> list) {
        if (current >= candidates.length) return;
        if (currentSum > target) return;
        if (currentSum == target) {
            output.add(new ArrayList<>(list));
            return;
        }
        for (int i = current; i < candidates.length; i++) {
            list.add(candidates[i]);
            combinationSum(candidates, target, i, currentSum + candidates[i], output, list);
            list.remove(list.size() - 1);
        }
    }
}
