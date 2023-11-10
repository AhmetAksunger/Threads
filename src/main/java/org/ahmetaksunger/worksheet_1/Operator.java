package org.ahmetaksunger.worksheet_1;

public class Operator {
    public static double sum(int[] arr, int numThreads) throws InterruptedException {

        if (numThreads > arr.length) {
            throw new RuntimeException("Number of threads cannot be greater than the array length!");
        }

        int min, max;
        double sum = 0;
        OperationThread[] threads = new SumThread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            min = (i * arr.length) / numThreads;
            max = ((i + 1) * arr.length) / numThreads;
            threads[i] = new SumThread(arr, min, max);
            threads[i].start();
        }

        for (OperationThread sumThread : threads) {
            sumThread.join();
            sum += sumThread.getAnswer();
        }

        return sum;
    }

    public static double average(int[] arr, int numThreads) throws InterruptedException {
        return sum(arr, numThreads) / arr.length;
    }

    public static double multiply(int[] arr, int numThreads) throws InterruptedException {

        if (numThreads > arr.length) {
            throw new RuntimeException("Number of threads cannot be greater than the array length!");
        }

        int min, max;
        OperationThread[] threads = new MultiplyThread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            min = (i * arr.length) / numThreads;
            max = ((i + 1) * arr.length) / numThreads;
            threads[i] = new MultiplyThread(arr, min, max);
            threads[i].start();
        }

        double result = 1;
        for (OperationThread multiplyThread : threads) {
            multiplyThread.join();
            result *= multiplyThread.getAnswer();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        try {
            System.out.println("SUM: " + Operator.sum(arr, 3));
            System.out.println("MULTIPLY: " + Operator.multiply(arr, 5));
            System.out.println("AVERAGE: " + Operator.average(arr, 8));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}