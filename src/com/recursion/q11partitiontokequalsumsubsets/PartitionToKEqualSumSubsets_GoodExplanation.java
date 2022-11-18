package com.recursion.q11partitiontokequalsumsubsets;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/partition-to-k-equal-sum-subsets/</link>
 *         LeetCode
 */
public class PartitionToKEqualSumSubsets_GoodExplanation {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for( int num: nums) sum+=num;
		
		// if sum not divisible by k
		if(sum%k != 0) return false;
		
		boolean []alreadyPicked = new boolean[nums.length];
		int reqSum = sum/k;
		return canPartitionKSubsets(0, 1, 0, reqSum, k, nums, alreadyPicked);
	}

	// for 1 bucket go through each element in array asking if they want to be in this bucket or not
	private boolean canPartitionKSubsets(int i, int bucketNum, int bucketSum, int reqSum, int k, int[] nums,
			boolean[] alreadyPicked) {
		if (bucketNum > k) {
			return true;
		}
		if (bucketSum == reqSum) {
			// move to next bucket ==> start from first of array, so i=0 and bucketSum = 0
			return canPartitionKSubsets(0, bucketNum + 1, 0, reqSum, k, nums, alreadyPicked);
		}
		if (bucketSum > reqSum) {
			return false;
		}
		if (i >= nums.length)
			return false;
		if (alreadyPicked[i]) {
			return canPartitionKSubsets(i + 1, bucketNum, bucketSum, reqSum, k, nums, alreadyPicked);
		} else {
			alreadyPicked[i] = true;
			bucketSum += nums[i];

			// element[i] choose to be in bucket
			boolean found1 = canPartitionKSubsets(i + 1, bucketNum, bucketSum, reqSum, k, nums, alreadyPicked);

			alreadyPicked[i] = false;
			bucketSum -= nums[i];

			// element[i] choose not to be in bucket
			boolean found2 = canPartitionKSubsets(i + 1, bucketNum, bucketSum, reqSum, k, nums, alreadyPicked);

			// if bucketSum == reqSum in any of those recursive calls
			if (found1 || found2)
				return true;
		}
		return false;
	}
}