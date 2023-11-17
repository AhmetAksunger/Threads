package org.ahmetaksunger.lecture_3;

public class Consumer extends Thread{
    private SharedCounter sh;
    public Consumer(SharedCounter sh) {
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
                sh.decrease();
            }
            catch (InterruptedException e) {
                // TODO: handle exception
            }
        }
    }


}