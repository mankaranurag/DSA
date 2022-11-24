package com.arrays;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/rotate-image/</link> LeetCode
 */
public class RotateImage {

	public void rotate(int[][] matrix) {
		int n = matrix.length;
		// Tranpose of a matrix
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				swap(matrix, i, j, j, i);
			}
		}

		// reverse a matrix by Columns
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				swap(matrix, i, j, i, n - 1 - j);
			}
		}
	}

	private void swap(int[][] matrix, int i, int j, int k, int l) {
		int temp = matrix[i][j];
		matrix[i][j] = matrix[k][l];
		matrix[k][l] = temp;
	}
}
