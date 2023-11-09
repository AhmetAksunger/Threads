package org.ahmetaksunger.lecture_1;

public class ParallelMessage extends Thread {
    private String message;

    public ParallelMessage(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        ParallelMessage message1 = new ParallelMessage("Message 1");
        ParallelMessage message2 = new ParallelMessage("Message 2");

        message1.start();
        message2.start();
    }
}
