package org.ahmetaksunger.lecture_2.reentrant_lock;

import org.ahmetaksunger.lecture_2.ATM;

import java.util.concurrent.locks.ReentrantLock;

public class UserReentrantLock extends Thread {
    private ATM atm;
    private int amount;
    private ReentrantLock lock;

    public UserReentrantLock(ATM atm, int amount, ReentrantLock lock) {
        this.atm = atm;
        this.amount = amount;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        String message = atm.withdraw(amount);
        System.out.println(getName() + " " + message);
        lock.unlock();
    }
}
