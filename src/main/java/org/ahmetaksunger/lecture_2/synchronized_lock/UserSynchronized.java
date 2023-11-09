package org.ahmetaksunger.lecture_2.synchronized_lock;

import org.ahmetaksunger.lecture_2.ATM;

public class UserSynchronized extends Thread{
    private ATMSynchronized atm;
    private int amount;

    public UserSynchronized(ATMSynchronized atm, int amount) {
        this.atm = atm;
        this.amount = amount;
    }

    @Override
    public void run() {
        String message = atm.withdraw(amount);
        System.out.println(getName() + " " + message);
    }
}
