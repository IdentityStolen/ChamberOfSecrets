/**
 * 
 */
package com.learn;

import java.util.Scanner;

/**
 * @author SK030960
 *
 */
public class ScannerUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		if (!sc.hasNextInt()) System.out.println("Hello " + s);
		sc.close();
	}

}
