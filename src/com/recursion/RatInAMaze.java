package com.recursion;

import java.util.ArrayList;

/**
 * @author Anurag <br />
 *         <link>https://www.codingninjas.com/codestudio/problems/rat-in-a-maze_1215030</link>
 *         LeetCode
 */
public class RatInAMaze {
	public static ArrayList<String> findPath(int[][] arr, int n) {
		ArrayList<String> res = new ArrayList<>();
		boolean[][] isVisited = new boolean[n][n];
		findPath(arr, n, 0, 0, res, "", isVisited);
		return res;
	}

	private static void findPath(int[][] arr, int n, int i, int j, ArrayList<String> res, String path,
			boolean[][] isVisited) {

		if (i == n - 1 && j == n - 1) {
			// path found
			// add to arrayList
			if (arr[i][j] == 1)
				res.add(path);
			return;
		}

		if (i < 0 || i >= n || j < 0 || j >= n)
			return;
		if (arr[i][j] == 1 && !isVisited[i][j]) {
			isVisited[i][j] = true;
			findPath(arr, n, i - 1, j, res, path + "U", isVisited);
			findPath(arr, n, i + 1, j, res, path + "D", isVisited);
			findPath(arr, n, i, j + 1, res, path + "R", isVisited);
			findPath(arr, n, i, j - 1, res, path + "L", isVisited);
			isVisited[i][j] = false;
		}
		return;
	}
}
