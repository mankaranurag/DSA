package com.arrays;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/</link>
 * LeetCode
 */
public class MaximumPointsYouCanObtainFromCards {
    // HELP
    // https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/discuss/597825/Simple-Clean-Intuitive-Explanation-with-Visualization
    public int maxScore(int[] cardPoints, int k) {
        if (k == 0) return 0;

        int totalPoints = 0;
        for (int i = 0; i < k; i++) {
            totalPoints += cardPoints[i];
        }
        // System.out.println(totalPoints);

        if (k == cardPoints.length) {
            return totalPoints;
        }
        int max = totalPoints;
        int l = cardPoints.length - 1;
        for (int i = 0; i < k; i++) {
            totalPoints = totalPoints - cardPoints[k - i - 1] + cardPoints[l - i];
            max = Math.max(max, totalPoints);
            // System.out.println(totalPoints + " " + max);
        }

        return max;
    }

    // [61,5,22,64,14,16,93,28,7,99,8,17,2,83,9,88,16,97,33,50,78,5,78,100,100,44,43,73,14,31,1,72,93,42,48,49,3,26,59,8,20,39,40,67,27]
    // 34
}
