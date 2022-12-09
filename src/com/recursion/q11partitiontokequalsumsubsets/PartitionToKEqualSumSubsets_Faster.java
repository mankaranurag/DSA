package com.recursion.q11partitiontokequalsumsubsets;

import java.util.Arrays;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/partition-to-k-equal-sum-subsets/</link>
 * LeetCode
 */
public class PartitionToKEqualSumSubsets_Faster {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums)
            sum += num;

        // sum%k must equal to 0 if not just return false
        // if we have to to divide the array greater than array size retun false(we
        // can't)
        if (sum % k != 0 || nums.length < k)
            return false;

        // sort so we can take last element and start filling our bucket
        Arrays.sort(nums);

        int target = sum / k;
        int[] buckets = new int[k];
        return canPartitionKSubsets(nums.length - 1, target, buckets, nums);
    }

    private boolean canPartitionKSubsets(int i, int target, int[] buckets, int[] nums) {
        if (i < 0)
            return true;
        for (int counter = 0; counter < buckets.length; counter++) {

            if (buckets[counter] + nums[i] <= target) {
                buckets[counter] += nums[i];
                if (canPartitionKSubsets(i - 1, target, buckets, nums))
                    return true;
                buckets[counter] -= nums[i];
            }

            // if this bucket is empty means we have not taken any elements in the bucket;
            // it will go to above if atleast once until and unless there is an element in
            // nums that is greater then target, that means we cant have that element in any
            // bucket hence return false
            if (buckets[counter] == 0)
                break;
        }
        return false;
    }
}
