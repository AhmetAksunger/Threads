package org.ahmetaksunger.lecture_1;

public class ParallelMessageWithRunnable implements Runnable {

    private String message;

    public ParallelMessageWithRunnable(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println(message);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        ParallelMessageWithRunnable message1 = new ParallelMessageWithRunnable("Message 1");
        ParallelMessageWithRunnable message2 = new ParallelMessageWithRunnable("Message 2");
        Thread t1 = new Thread(message1);
        Thread t2 = new Thread(message2);
        t1.start();
        t2.start();
    }
}
