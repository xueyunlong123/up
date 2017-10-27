package Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xueyunlong on 17-9-14.
 * 可重入锁使用
 */
public class ReentrantLockExample {
    private ReentrantLock reentrantLock = new ReentrantLock();

    private void test(){
        reentrantLock.lock();
        System.out.println("进行原子操作");
        try {
            Thread.sleep(3000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ReentrantLockExample reentrantLockExample = new ReentrantLockExample();
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Thread(reentrantLockExample::test));
        }
    }
}
