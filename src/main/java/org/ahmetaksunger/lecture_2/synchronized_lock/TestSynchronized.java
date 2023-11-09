package org.ahmetaksunger.lecture_2.synchronized_lock;

public class TestSynchronized {
    public static void main(String[] args) {
        ATMSynchronized atm = new ATMSynchronized(1000);
        UserSynchronized user1 = new UserSynchronized(atm, 600);
        UserSynchronized user2 = new UserSynchronized(atm, 300);
        UserSynchronized user3 = new UserSynchronized(atm, 340);
        UserSynchronized user4 = new UserSynchronized(atm, 500);

        user1.start();
        user2.start();
        user3.start();
        user4.start();
    }
}
