package org.ahmetaksunger.lecture_2;

public class ATM {
    private int balance;

    public ATM(int balance) {
        this.balance = balance;
    }

    public String withdraw(int amount) {
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
