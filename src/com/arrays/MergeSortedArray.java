package com.arrays;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/merge-sorted-array/</link>
 * LeetCode
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int[] newm = new int[m];
        for (int k = 0; k < m; k++) {
            newm[k] = nums1[k];
        }
        int k = 0;
        while (i < m && j < n) {
            if (newm[i] <= nums2[j]) {
                nums1[k] = newm[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (j < n) {
            nums1[k] = nums2[j];
            k++;
            j++;
        }
        while (i < m) {
            nums1[k] = newm[i];
            k++;
            i++;
        }
    }
}
