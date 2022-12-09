package com.arrays;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/next-permutation</link> LeetCode
 * https://leetcode.com/problems/next-permutation/discuss/13994/Readable-code-without-confusing-ij-and-with-explanation
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        // pivot is the element just before the non-increasing (weakly decreasing)
        // suffix
        int pivot = indexOfLastPeak(nums) - 1;
        // paritions nums into [prefix pivot suffix]
        if (pivot != -1) {
            int nextPrefix = lastIndexOfGreater(nums, nums[pivot]);
            // in the worst case it's suffix[0]
            // next prefix must exist because pivot < suffix[0], otherwise pivot would be
            // part of suffix
            swap(nums, pivot, nextPrefix); // this minimizes the change in prefix
        }
        reverseArray(nums, pivot + 1);
        // reverses the whole list if there was no pivot
    }

    /**
     * Find the last element which is a peak. In case there are multiple equal
     * peaks, return the first of those.
     *
     * @return first index of last peak
     */
    int indexOfLastPeak(int[] nums) {
        for (int i = nums.length - 1; 0 < i; --i) {
            if (nums[i - 1] < nums[i])
                return i;
        }
        return 0;
    }

    /**
     * @param nums
     * @param threshold
     * @return last index where the {@code num > threshold} or -1 if not found
     */
    int lastIndexOfGreater(int[] nums, int threshold) {
        for (int i = nums.length - 1; 0 <= i; --i) {
            if (threshold < nums[i])
                return i;
        }
        return -1;
    }

    /**
     * Reverse numbers starting from an index till the end.
     */
    void reverseArray(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
