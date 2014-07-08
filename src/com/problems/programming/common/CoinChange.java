
package com.problems.programming.common;

import java.util.ArrayList;
import java.util.List;

public class CoinChange{

	private static final int[] DENOMINATIONS = {1,2,3};
	private static int numSolutions = 0;

	public static void main(String[] args) {

		change(4);
		System.out.println("Number of solutions:"+numSolutions);;
	}

	public static void change(int amount) {

		change(amount, new ArrayList<Integer>(), 0);
	}

	private static void change(int remaining, List<Integer> coins, int pos) {

		if (remaining == 0) {
			System.out.println(coins);
			numSolutions++;
		}
		else {
			if (remaining >= DENOMINATIONS[pos]) {
				coins.add(DENOMINATIONS[pos]);
				change(remaining - DENOMINATIONS[pos], coins, pos);
				coins.remove(coins.size() - 1);
			}
			if (pos + 1 < DENOMINATIONS.length) {
				change(remaining, coins, pos + 1);
			}
		}
	}

}
