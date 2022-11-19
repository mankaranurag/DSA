package com.recursion;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/flood-fill/</link> LeetCode
 */
public class FloodFill {
	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		int[][] output = new int[image.length][image[0].length];
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[i].length; j++) {
				output[i][j] = image[i][j];
			}
		}
		floodFill(image, output, sr, sc, color, image[sr][sc]);
		return output;
	}

	private void floodFill(int[][] image, int[][] output, int sr, int sc, int color, int startColor) {
		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
			return;
		}
		// check if connected color is of start color
		if (image[sr][sc] != startColor)
			return;

		// check if this is already traversed,
		// if image color is start color and output image color is set to floodFill
		// Color
		if (output[sr][sc] == color)
			return;

		//
		output[sr][sc] = color;

		// top, bottom, left, right
		floodFill(image, output, sr, sc - 1, color, startColor);
		floodFill(image, output, sr - 1, sc, color, startColor);
		floodFill(image, output, sr + 1, sc, color, startColor);
		floodFill(image, output, sr, sc + 1, color, startColor);
	}
}
