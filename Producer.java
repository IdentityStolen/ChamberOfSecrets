package com.learn;

import java.util.*;

public class Producer extends ProducerConsumerDemo implements Runnable {
	public void run() {
		for(int i = 0; i < 5; i++) {
			produce(i);
		}
	}
}
