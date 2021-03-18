package sort_algorithm.test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 生产者消费者
 */

class Buffer{
    private static Queue<Integer> buffer = new LinkedList<>();

    private int cap = 5;

    public synchronized void add(int val) throws InterruptedException {
        while (buffer.size() >= cap){
            wait();
        }
        buffer.add(val);
        notify();
    }

    public synchronized int remove() throws InterruptedException {
        while (buffer.size() == 0){
            wait();
        }
        int val = buffer.poll();
        notify();
        return val;
    }
}

class Consumer extends Thread{
    private Buffer buffer;

    public Consumer(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run(){
        for(int i = 0;i < 10;i++){
            try {
                int val = buffer.remove();
                System.out.println(Thread.currentThread().getName() + "消费了：" + val);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Productor extends Thread{
    private Buffer buffer;

    public Productor(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run(){
        for(int i = 0;i < 10;i++){
            try {
                buffer.add(i);
                System.out.println(Thread.currentThread().getName() + "生产了：" + i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
public class Test {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Consumer consumer = new Consumer(buffer);
        Productor productor = new Productor(buffer);

        consumer.start();
        productor.start();
    }

}
