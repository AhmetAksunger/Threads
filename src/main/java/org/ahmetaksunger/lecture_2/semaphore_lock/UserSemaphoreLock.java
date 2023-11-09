package org.ahmetaksunger.lecture_2.semaphore_lock;

import org.ahmetaksunger.lecture_2.ATM;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class UserSemaphoreLock extends Thread {
    private ATM atm;
    private int amount;
    private Semaphore semaphore;

    public UserSemaphoreLock(ATM atm, int amount, Semaphore semaphore) {
        this.atm = atm;
        this.amount = amount;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            String message = atm.withdraw(amount);
            System.out.println(getName() + " " + message);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
