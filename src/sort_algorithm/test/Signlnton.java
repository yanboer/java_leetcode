package sort_algorithm.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * DCL  Double Check Locking
 */
public class Signlnton {

    private Signlnton(){}

    private static volatile Signlnton signlnton = null;

    public static Signlnton getInstance(){
        if(signlnton == null){
            synchronized (Signlnton.class){
                if(signlnton == null){
                    signlnton = new Signlnton();
                }
            }
        }
        return signlnton;
    }

    //测试
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(
                3,
                5,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5));

        for(int i = 0;i < 10;i++){
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName() +":" + Signlnton.getInstance().hashCode());
            });
        }

        executorService.shutdown();
    }
}
