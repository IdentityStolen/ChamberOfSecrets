package com.learn;

public class Consumer extends ProducerConsumerDemo implements Runnable {
	public void run() {
		for(int i = 0; i < 5; i++) {
			consume();
		}
	}
}
