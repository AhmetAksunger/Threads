package org.ahmetaksunger.lecture_3;

public class Test {
    public static void main(String[] args) {
        SharedCounter sharedField = new SharedCounter(20);

        Producer producer1 = new Producer(sharedField);
        Producer producer2 = new Producer(sharedField);
        Producer producer3 = new Producer(sharedField);
        Consumer consumer = new Consumer(sharedField);

        producer1.start();
        producer2.start();
        producer3.start();
        consumer.start();
    }
}
