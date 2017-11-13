package com.learn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A demo example having 1 Produce and 1 Consumer - using {@link Object}#wait() and {@link Object}.notify()
 * methods to communicate with each other.
 * <p>
 * <p>
 * Also, assumption is Producer and Consumer are totally independent of each other and there is no state sharing between them
 * to replicate real world scenario.
 * <p>
 * Producer produces onto some queue with finite size ; and blocks if space is NOT available.
 * <p>
 * Note that below is very rudimentary implementation of 1 PC problem and by no means it is a good code! For starters , its NOT THREAD SAFE ! Real solution would be teasing apart
 * Producer Storage and Consumer into separate objects and design code with concurrency in mind! Anyway....
 *
 * Most IMPORTANT thing to know about notify
 *
 * * The awakened thread will not be able to proceed until the current
 * thread relinquishes the lock on this object. The awakened thread will
 * compete in the usual manner with any other threads that might be
 * actively competing to synchronize on this object; for example, the
 * awakened thread enjoys no reliable privilege or disadvantage in being
 * the next thread to lock this object.
 * <p>
 * This method should only be called by a thread that is the owner
 * of this object's monitor. A thread becomes the owner of the
 * object's monitor in one of three ways:
 * <ul>
 * <li>By executing a synchronized instance method of that object.
 * <li>By executing the body of a {@code synchronized} statement
 *     that synchronizes on the object.
 * <li>For objects of type {@code Class,} by executing a
 *     synchronized static method of that class.
 * </ul>
 * <p>
 * Only one thread at a time can own an object's monitor.
 *
 *
 * <p>
 * We could use {@link java.util.concurrent.BlockingQueue} for such kinds of problems if we are allowed to take advantage of collections.
 * <p>
 * Better solution could be publishing an batchEvent and consumers being OBSERVERs to Storage object - and bulk consume product in 1 go...
 * OR
 * Very sophisticated mechanism now exist to achieve 1-PC / N-PC - one of them being
 * Disruptor.
 */
public class ProducerConsumerWaitNotifyDemo {

    private final Queue<Integer> storage = new LinkedList<>();
    private final int maxSize = 5;
    private final AtomicInteger producerCounter = new AtomicInteger(0);

    private final Object monitor = new Object();

    public Runnable getProducer() {
        return producer;
    }

    public Runnable getConsumer() {
        return consumer;
    }

    private final Runnable producer = () -> {

        if (storage.size() <= maxSize) {
            storage.offer(producerCounter.getAndIncrement());
            System.out.println("Produced " + producerCounter.get());
            if (storage.size() == 1) {
                System.out.println("Notifying consumers...");
                synchronized (monitor) {
                    monitor.notifyAll();
                }
            }
        } else {
            System.out.println("Queue Full...Gonna wait until there is some space");
            try {
                synchronized (monitor) {
                    monitor.wait(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private final Runnable consumer = () -> {
        if (!storage.isEmpty()) {
            if (storage.size() <= maxSize)
                System.out.println("Consumed " + storage.poll());
            if (storage.size() == (maxSize - 1)) {
                System.out.println("Finally there is some space now in Q - notifying Producer");
                synchronized (monitor) {
                    monitor.notifyAll();
                }
            }
        } else {
            System.out.println("Nothing to consume...Will wait!");
            try {
                synchronized (monitor) {
                    monitor.wait(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public static void main(String[] args) throws InterruptedException {

        ProducerConsumerWaitNotifyDemo producerConsumerWaitNotifyDemo = new ProducerConsumerWaitNotifyDemo();

        ScheduledExecutorService producerExecutorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService consumerExecutorService = Executors.newSingleThreadScheduledExecutor();

        //Slow Producer(1 product every 5s) and Fast Consumer(1 second for 1 product consumption).
        consumerExecutorService.scheduleAtFixedRate(producerConsumerWaitNotifyDemo.getConsumer(),1,1, TimeUnit.SECONDS);
        producerExecutorService.scheduleAtFixedRate(producerConsumerWaitNotifyDemo.getProducer(),1,5, TimeUnit.SECONDS);


        Thread.sleep(100000);
        System.out.println("Terminating now...");
        consumerExecutorService.shutdown();
        producerExecutorService.shutdown();

    }


}
