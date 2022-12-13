package com.arrays.q25foursum;

import java.util.*;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/4sum/</link>
 * LeetCode
 */
public class FourSum_Recursion {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4 ) return result;
        Arrays.sort(nums);
        kSum_Trim(nums, target, 4, 0, result, new ArrayList<>());
        return result;
    }

    void kSum_Trim(int[] a, int target, int k, int start, List<List<Integer>> result, List<Integer> path) {
        int max = a[a.length - 1];
        if (a[start] * k > target || max * k < target) return;

        if (k == 2) {                        // 2 Sum
            int left = start;
            int right = a.length - 1;
            while (left < right) {
                if (a[left] + a[right] < target) left++;
                else if (a[left] + a[right] > target) right--;
                else {
                    result.add(new ArrayList<>(path));
                    result.get(result.size() - 1).addAll(Arrays.asList(a[left], a[right]));
                    left++;
                    right--;
                    while (left < right && a[left] == a[left - 1]) left++;
                    while (left < right && a[right] == a[right + 1]) right--;
                }
            }
        } else {                        // k Sum
            for (int i = start; i < a.length - k + 1; i++) {
                if (i > start && a[i] == a[i - 1]) continue;
                if (a[i] + max * (k - 1) < target) continue;
                if (a[i] * k > target) break;
                if (a[i] * k == target) {
                    if (a[i + k - 1] == a[i]) {
                        result.add(new ArrayList<>(path));
                        List<Integer> temp = new ArrayList<>();
                        for (int x = 0; x < k; x++) temp.add(a[i]);
                        result.get(result.size() - 1).addAll(temp);    // Add result immediately.
                    }
                    break;
                }
                path.add(a[i]);
                kSum_Trim(a, target - a[i], k - 1, i + 1, result, path);
                path.remove(path.size() - 1);        // Backtracking
            }
        }
    }


    // EDge Test Case
    // Input:
    // [1000000000,1000000000,1000000000,1000000000]
    // -294967296
    // Output:
    // []

}
