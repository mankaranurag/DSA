package com.arrays;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/fibonacci-number/</link> LeetCode
 */
public class FibonacciNumber {

	// recursive
	public int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return (fib(n - 1) + fib(n - 2));
	}

	//
	public int fibIterative(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int prevfib = 0;
		int fib = 1;
		for (int i = 2; i <= n; i++) {
			int temp = fib;
			fib += prevfib;
			prevfib = temp;
		}
		return fib;
	}
}
