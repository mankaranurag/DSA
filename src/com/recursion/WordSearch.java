package com.recursion;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/word-search/</link> LeetCode
 */
public class WordSearch {
	// Test Cases
	// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
	// "ABCCED"
	// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
	// "SEE"
	// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
	// "ABCB"
	// [["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]
	// "ABCESEEEFS"
	public boolean exist(char[][] board, String word) {

		char a = word.charAt(0);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == a) {
					boolean[][] isVisited = new boolean[board.length][board[0].length];
					if (exist(board, word, i, j, 0, isVisited))
						return true;
				}
			}
		}
		return false;
	}

	private boolean exist(char[][] board, String word, int i, int j, int counter, boolean[][] isVisited) {
		if (counter >= word.length())
			return true;
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
			return false;
		if (isVisited[i][j])
			return false;
		char c = word.charAt(counter);
		if (c == board[i][j]) {
			// System.out.println(c);
			isVisited[i][j] = true;
			if (exist(board, word, i + 1, j, counter + 1, isVisited))
				return true;
			if (exist(board, word, i - 1, j, counter + 1, isVisited))
				return true;
			if (exist(board, word, i, j + 1, counter + 1, isVisited))
				return true;
			if (exist(board, word, i, j - 1, counter + 1, isVisited))
				return true;
			isVisited[i][j] = false;
		}

		return false;
	}
}
