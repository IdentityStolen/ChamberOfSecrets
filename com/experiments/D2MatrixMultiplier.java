/**
 * 
 */
package com.experiments;

/**
 * @author SK030960
 *
 */
public class D2MatrixMultiplier {

	/**
	 * @param args
	 */
	public int[][] multiply(int[][] a, int[][] b){
		int[][] c = new int[2][2];	//Need to dynamically calculate output matrix size ?
		for (int i = 0;i < 2;i++) {
			for(int j=0;j<2;j++) {
				c[i][j] = 0;
			}
		}
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				for(int k=0;k<2;k++) {
					c[i][j] = c[i][j] + a[i][k] * b[k][j];
				}
			}
		}
		return c;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{1,2},{2,1}};
		int[][] b = {{1,2},{2,1}};
		D2MatrixMultiplier d = new D2MatrixMultiplier();
		int[][] c = d.multiply(a, b);
		for (int i = 0;i < 2;i++) {
			for(int j=0;j<2;j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}

}
