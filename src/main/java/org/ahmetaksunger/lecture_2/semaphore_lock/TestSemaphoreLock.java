package org.ahmetaksunger.lecture_2.semaphore_lock;

import org.ahmetaksunger.lecture_2.ATM;
import org.ahmetaksunger.lecture_2.reentrant_lock.UserReentrantLock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class TestSemaphoreLock {
    public static void main(String[] args) {
        ATM atm = new ATM(1000);
        Semaphore semaphore = new Semaphore(1);
        UserSemaphoreLock user1 = new UserSemaphoreLock(atm, 600, semaphore);
        UserSemaphoreLock user2 = new UserSemaphoreLock(atm, 300, semaphore);
        UserSemaphoreLock user3 = new UserSemaphoreLock(atm, 340, semaphore);
        UserSemaphoreLock user4 = new UserSemaphoreLock(atm, 500, semaphore);

        user1.start();
        user2.start();
        user3.start();
        user4.start();
    }
}
