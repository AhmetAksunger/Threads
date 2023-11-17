package org.ahmetaksunger.lecture_3;

import java.util.Random;

public class SharedCounter {
    private int c;
    private Random ran;
    public SharedCounter(int k) {
        // TODO Auto-generated constructor stub
        c=k;
        ran=new Random();
    }
    // increase
    public synchronized void increase( ) {
        int p= ran.nextInt(5);
        if(1+c>100) {

            try {
                System.
                        out.println("Producer wait ");
                System.
                        out.println("current value: "
                                +c);
                wait();
            }
            catch (Exception e) {
                // TODO: handle exception
            }
        }// end of the if block
        c=c+1;
        System.
                out.println("Producer update:"
                        +c);
        notifyAll();
    }

    // decrease
    public synchronized void decrease( ) {
        int p= ran.nextInt(5);
        if(c-1<0) {

            try {
                System.
                        out.println("Consumuer wait ");
                System.
                        out.println("current value"
                                +c);
                wait();
            }
            catch (Exception e) {
                // TODO: handle exception
            }
        }// end of the if block
        c=c-1;
        System.
                out.println("Consumer update:"
                        +c);
        notifyAll();
    }

}