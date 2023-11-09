package org.ahmetaksunger.lecture_2.reentrant_lock;

import org.ahmetaksunger.lecture_2.ATM;

import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {
    public static void main(String[] args) {
        ATM atm = new ATM(1000);
        ReentrantLock lock = new ReentrantLock();
        UserReentrantLock user1 = new UserReentrantLock(atm, 600, lock);
        UserReentrantLock user2 = new UserReentrantLock(atm, 300, lock);
        UserReentrantLock user3 = new UserReentrantLock(atm, 340, lock);
        UserReentrantLock user4 = new UserReentrantLock(atm, 500, lock);

        user1.start();
        user2.start();
        user3.start();
        user4.start();
    }
}
