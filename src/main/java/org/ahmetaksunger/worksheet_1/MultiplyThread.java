package org.ahmetaksunger.worksheet_1;

public class MultiplyThread extends OperationThread{

    public MultiplyThread(int[] arr, int min, int max) {
        super(arr, min, max);
        this.setAnswer(1);
    }

    @Override
    public double operation(int x) {

        return this.getAnswer() * x;
    }
}
