package org.ahmetaksunger.lecture_2.synchronized_lock;

public class ATMSynchronized {
    private int balance;

    public ATMSynchronized(int balance) {
        this.balance = balance;
    }

    public synchronized String withdraw(int amount) {
        if (this.balance >= amount) {
            try {
                Thread.currentThread().sleep(1000);
                this.balance -= amount;
                return "Withdrawal successful! Withdrawn amount is " + amount + " and remaining balance is " + this.balance;
            } catch (InterruptedException e) {
                return e.getMessage();
            }
        } else {
            return "Withdrawal failed! Insufficient balance!";
        }
    }
}
