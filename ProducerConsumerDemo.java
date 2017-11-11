/**
 * 
 */
package com.learn;

import java.util.*;

import javax.swing.plaf.SliderUI;

/**
 * @author SK030960
 *
 */
public class ProducerConsumerDemo {

	/**
	 * @param args
	 */
	private boolean bAvailable = false;
	private List<Integer> sharedMem = new ArrayList<>();
	
	public synchronized void produce(int item) {
//		if (bAvailable) {
//			try {
//				wait();
//			}
//			catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sharedMem.add(item);
		bAvailable = true;
		System.out.println("Produced " + item);
		notify();
	}
	
	public synchronized void consume() {		//this isn't running
		if(!bAvailable) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int item = sharedMem.remove(0);
		if (sharedMem.isEmpty()) {
			bAvailable = false;
			notify();
		}
		System.out.println("Consumed " + item);
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producer p = new Producer();
		Consumer c = new Consumer();
		Thread pThread = new Thread(p);
		Thread cThread = new Thread(c);
		cThread.start();
		pThread.start();
	}

}
