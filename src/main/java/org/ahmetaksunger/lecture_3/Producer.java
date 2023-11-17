package org.ahmetaksunger.lecture_3;

public class Producer extends Thread{
    private SharedCounter sh;
    public Producer(SharedCounter sh) {
        // TODO Auto-generated constructor stub
        this.sh=sh;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(true) {
            try {
                Thread.currentThread().
                        sleep(500);
                sh.increase();
            }
            catch (InterruptedException e) {
                // TODO: handle exception
            }
        }
    }


}