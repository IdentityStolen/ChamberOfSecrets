/**
 * 
 */
package com.experiments;

import java.math.BigInteger;

/**
 * @author SK030960
 *
 */
public class Fibonacci<T> {

	/**
	 * @param args
	 */
	private T pos;
	
	public void setPos (T pos) {
		this.pos = pos;
	}
	
	public T getPos() {
		return this.pos;
	}
	
	public int fibWithRecur(int pos) {
		if (pos < 0) return -1;
		if (pos == 0) return 0;
		else if ((pos == 1) || (pos == 2)) return 1;
		
		return fibWithRecur(pos - 1) + fibWithRecur(pos - 2);
	}
	
	public int fibWithoutRecur(int pos) {
		if (pos < 0) return -1;
		pos--;
		int prev = 0, curr = 1, next = 0;
		for (int i=0;i<pos;i++) {
			next = prev + curr;
			prev = curr;
			curr = next;
		}
		return next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Fibonacci<BigInteger> fib = new Fibonacci<>();
		BigInteger i = new BigInteger("20");
		fib.setPos(i);
		
		System.out.println(fib.fibWithRecur(20));
		System.out.println(fib.fibWithoutRecur(20));
	}

}
