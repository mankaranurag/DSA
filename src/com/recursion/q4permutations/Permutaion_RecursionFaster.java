package com.recursion.q4permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/permutations/<link> LeetCode
 */
public class Permutaion_RecursionFaster {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void permute(int[] nums, int j, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = j; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                swap(nums, i, j);
                permute(nums, j + 1, res, list);
                swap(nums, i, j);
                list.remove(list.size() - 1);

            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
