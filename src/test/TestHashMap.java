package test;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
        ThreadDemo t1 = new ThreadDemo();
        ThreadDemo t2 = new ThreadDemo();

        t1.start();
        t2.start();

        for(int i = 0;i < ThreadDemo.map.size();i++){
            System.out.println(ThreadDemo.map.get(i));
        }
    }
}

class ThreadDemo extends Thread{

    public static Map<Integer,Integer> map = new HashMap<>();

    @Override
    public void run() {
        for(int i = 1;i < 17;i++){
            map.put(i,i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
