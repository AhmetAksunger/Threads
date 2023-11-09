package org.ahmetaksunger.lecture_1;

public class ParallelSum extends Thread {
    private int sum;
    private int from, to;

    public ParallelSum(int from, int to) {
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
        ParallelSum sum1 = new ParallelSum(1, 100);
        ParallelSum sum2 = new ParallelSum(101, 200);

        sum1.start();
        sum2.start();

        /*
         * If we don't wait for the threads to finish, the result will be
         * incorrect.
         * So in this case main thread will wait for sum1 & sum2 threads to finish.
         */
        try {
            sum1.join();
            sum2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(sum1.getSum() + sum2.getSum());
    }
}
