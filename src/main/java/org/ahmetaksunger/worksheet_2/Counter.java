package org.ahmetaksunger.worksheet_2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class Counter extends Thread {

    private String[] arr;
    private Map<String, Integer> map;
    private ReentrantLock lockService;

    public Counter(String[] arr, Map<String, Integer> map, ReentrantLock lockService) {
        this.arr = arr;
        this.map = map;
        this.lockService = lockService;
    }

    @Override
    public void run() {
        for (String item : arr) {
            lockService.lock();
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
            lockService.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String[] s1 = new String[]{"a", "b", "c", "d", "c", "a", "b"};
        String[] s2 = new String[]{"a", "b", "c", "d", "c", "a", "b"};
        String[] s3 = new String[]{"a", "b", "c", "d", "c", "a", "b"};
        HashMap<String, Integer> map = new HashMap<>();
        ReentrantLock lock = new ReentrantLock();
        Counter c1 = new Counter(s1, map, lock);
        Counter c2 = new Counter(s2, map, lock);
        Counter c3 = new Counter(s3, map, lock);
        c1.start();
        c2.start();
        c3.start();

        c1.join();
        c2.join();
        c3.join();

        System.out.println(map);
    }
}
