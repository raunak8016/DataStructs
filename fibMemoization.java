/**
 * 
 * This class includes my FibMemoization method to calculate the 
 * n-th Fibonacci number using memoization
 * 
 * @author Raunak Sandhu
 * id - 30117897
 */


package application;

import java.util.HashMap;
import java.util.Map;

public class fibMemoization {		// class fibMemoization
	public long fibMemoization(int n, Map<Integer,Long> calculatedVals) {		// public method
		if (calculatedVals.containsKey(n)) return calculatedVals.get(n);		// check map to see if the n-th Fibonacci number is already stored
																				// if it is return and end method
		if (n == 0) return (long) 0;		// base case F(0)
		if (n == 1) return (long) 1;		// base case F(1)
		calculatedVals.put(n, fibMemoization(n-1, calculatedVals) + fibMemoization(n-2, calculatedVals));	// store F(n) as the sum of F(n-1) and F(n-2)
		return calculatedVals.get(n);		// return F(n) now that it is stored
	}

}
