package com.arrays;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/container-with-most-water/</link> LeetCode
 */
public class ContainerWithMostWater {

	public int maxArea(int[] height) {
        int start = 0, end = height.length -1;
        int max = Integer.MIN_VALUE;
        while(start < end){
            int tempVolume = getVolume(height, start, end);
            if(tempVolume > max) max = tempVolume;
            if(height[start] > height[end]) end--;
            else if(height[start] < height[end]) start++;
            else {start++; end--;}
        }
        return max;
    }
    
    private int getVolume(int []height,int i,int j){
        return ( (Math.abs(j-i)) * (Math.min(height[i], height[j])));
    }
}
