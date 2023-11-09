package org.ahmetaksunger.lecture_2;

public class User extends Thread{
    private ATM atm;
    private int amount;

    public User(ATM atm, int amount) {
        this.atm = atm;
        this.amount = amount;
    }

    @Override
    public void run() {
        String message = atm.withdraw(amount);
        System.out.println(getName() + " " + message);
    }
}
