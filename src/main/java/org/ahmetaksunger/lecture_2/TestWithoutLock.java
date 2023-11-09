package org.ahmetaksunger.lecture_2;

import org.ahmetaksunger.lecture_2.ATM;
import org.ahmetaksunger.lecture_2.User;

public class TestWithoutLock {
    public static void main(String[] args) {
        ATM atm = new ATM(1000);
        User user1 = new User(atm, 600);
        User user2 = new User(atm, 300);
        User user3 = new User(atm, 340);
        User user4 = new User(atm, 500);

        user1.start();
        user2.start();
        user3.start();
        user4.start();
    }
}
