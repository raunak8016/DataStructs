/**
 * 
 * This class includes my codings of the three Fib 
 * algorithms provided.
 * 
 * @author Raunak Sandhu
 * id - 30117897
 */


package application;

import java.util.HashMap;
import java.util.Map;

public class FibAlgorithms {		// class FibAlgorithms
	public int Fib1(int n) {		// Fib 1 method
		if (n<2) return n;			// check n<2 
		else {
			return Fib1(n-1) + Fib1(n-2);	// else return recursive calls
		}
	}
	
	public int Fib2(int n) {		// Fib 2 methods
		int i = 1;		// declare i
		int j = 0;		// declare j
		for (int k = 1; k<= n; k++) {	// loop over k<= n
			j = i+j;	// j = i + j
			i = j-i;	// i = j - i
		}
		return j;		// return j as F(n)
	}
	
	public int Fib3(int n) {		// Fib3 class
		int i = 1;		// i = 1
		int j = 0;		// j = 0
		int k = 0;		// k = 0
		int h = 1;		// h = 1
		while (n > 0) {		// while n>0 loop
			int t;		// declare t integer
			if (n % 2 != 0) {		// check if n is odd using modulo
				t = j*h;	// t = j*h
				j = i*h + j*k + t;		// j = i*h + j*k + t
				i = i*k + t;		// i = i*k + t
			}
			t = h*h;		// t = h*h
			h = 2*k*h + t;	// h = 2*k*h + t
			k = k*k + t;	// k = k*k + t
			n = n/2;		// n/2
		}
		return j;		// return j as F(n)
	}
}
