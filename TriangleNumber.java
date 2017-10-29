/**
 * 
 */
package com.experiments;

/**
 * @author SK030960
 * check if given number is a triangle number or not & tell how many levels are in that triangle
 * smart method would be by formula (-b +/- Sqrt(b^2 - 4ac)) / 2a, if roots are real then triangular number & 
 * smallest number would be level
 *
 */
public class TriangleNumber {

	/**
	 * @param args
	 */
	public static void ifTriangularnumber(int num) {
		int numAtlevel, temp, level;
		numAtlevel = 0;
		level = 0;
		while (numAtlevel < num) {
			level++;
			numAtlevel = numAtlevel + level;
		}
		if ((numAtlevel != 0) & (numAtlevel == num)) System.out.println("Level =" + level);
		else System.out.println("Number is not a triangular number");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ifTriangularnumber(0);
		ifTriangularnumber(15);
	}

}
