package com.pillingerphotography.katas;

public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(fib(1));
		System.out.println(fib(2));
		System.out.println(fib(3));
		System.out.println(fib(4));
		System.out.println(fib(5));
		System.out.println(fib(6));
	}

	private static int fib(int i) {
		if (i == 1)
		{
			return 0;
		}
		if (i == 2)
		{
			return 1;
		}
		else {
			return fib (i-1) +fib (i -2);
		}
	}

}
