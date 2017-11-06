/**
 * 
 */
package com.learn;

import java.util.*;

/**
 * @author SK030960
 *
 */
public class ExceptionLearner extends Exception {

	/**
	 * @param args
	 */
	private String message;
	
	public ExceptionLearner(String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
	}
	
	public void printMessage() {
		System.out.println(this.message);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
