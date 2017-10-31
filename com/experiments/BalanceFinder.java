/**
 * 
 */
package com.experiments;

/**
 * @author SK030960
 *
 */
public class BalanceFinder {

	/**
	 * @param args
	 */
	public static double getSum(double[] Arr) {
		double sum = 0;
		for (double f : Arr) {
			sum = sum + f;
		}
		return sum;
	}
	
	public static int findBalance(double[] Arr) {
		double sum = getSum(Arr);
		double left = 0, right = 0;
		int index = 0;
		for (double f : Arr) {
			right = sum - left - f;
			if (left == right) return index;
			left = left + f;
			index++;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] arr = {-7, 1, 5, 2, -4, 3, 0};
		int pos = findBalance(arr);
		if (pos == -1) { System.out.println("No Balance point for the array"); }
		else { System.out.println("Balabce Point of an array is:" + pos); }
	}

}
