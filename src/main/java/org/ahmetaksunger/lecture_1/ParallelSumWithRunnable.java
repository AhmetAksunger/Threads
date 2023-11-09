package org.ahmetaksunger.lecture_1;

public class ParallelSumWithRunnable implements Runnable {
    private int sum;
    private int from, to;

    public ParallelSumWithRunnable(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        for (int i = from; i <= to; i++) {
            sum += i;
        }
    }

    public int getSum() {
        return sum;
    }

    public static void main(String[] args) {
        ParallelSumWithRunnable sum1 = new ParallelSumWithRunnable(1, 100);
        ParallelSumWithRunnable sum2 = new ParallelSumWithRunnable(101, 200);

        Thread t1 = new Thread(sum1);
        Thread t2 = new Thread(sum2);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(sum1.getSum() + sum2.getSum());
    }
}
