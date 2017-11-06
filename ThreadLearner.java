/**
 * 
 */
package com.learn;

import javax.swing.plaf.SliderUI;

/**
 * @author SK030960
 *
 */
public class ThreadLearner implements Runnable{

	/**
	 * @param args
	 */
	private String threadName;
	static Integer i = 0;
	
	public ThreadLearner(String str) {
		// TODO Auto-generated constructor stub
		this.threadName = str;
	}
	
	public String getName() {
		return this.threadName;
	}
	
	public synchronized void run() {
		System.out.println("I am " + this.getName() + " printing " + i++);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadLearner t1 = new ThreadLearner("Shree");
		ThreadLearner t2 = new ThreadLearner("Chai");
		
		Thread t3,t4;
//		while (i<=4) {
		    t3 = new Thread(t1);
			t3.start();
//			try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			t4 = new Thread(t2);
			t4.start();
//			try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
	}

}
