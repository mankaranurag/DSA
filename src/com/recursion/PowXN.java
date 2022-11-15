package com.recursion;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/powx-n/</link> LeetCode
 */
public class PowXN {
	/**
	 * @param x
	 * @param n
	 * @return <br />
	 *         Lot of Edge Cases<br />
	 *         Constraints: <br />
	 *         -100.0 < x < 100.0 <br />
	 *         -231 <= n <= 231-1 <br />
	 *         n is an integer. <br />
	 *         -104 <= x^n <= 104 <br />
	 */
	public double myPow(double x, int n) {
		if (n == 0)
			return 1;
		if (n < 0) {
			x = 1 / x;
			if (n == -2147483648) {
				n = 2147483647;
				return x * myPow(x, n);
			}
			n = Math.abs(n);
		}
		if (n % 2 == 0)
			return myPow(x * x, n / 2);
		return x * myPow(x, n - 1);
	}
}
