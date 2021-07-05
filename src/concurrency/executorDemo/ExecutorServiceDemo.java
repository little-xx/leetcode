package concurrency.executorDemo;

import java.lang.reflect.Field;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {

    static int getThreadPoolRunState(ThreadPoolExecutor pool) throws Exception {
        Field f = ThreadPoolExecutor.class.getDeclaredField("runState");
        f.setAccessible(true);
        int v = f.getInt(pool);
        return v;
    }

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                new ThreadPoolExecutor.DiscardPolicy());

        for (int i = 0 ; i < 4; i++) {
            final int index = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("run task:" + index + " -> " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("run over:" + index + " -> " + Thread.currentThread().getName());
                }
            });
            System.out.println("before sleep");
            Thread.sleep(4000L);
            System.out.println("before shutdown");
            pool.shutdown();
            System.out.println("after shutdown(),pool.isTerminated=" + pool.isTerminated());
            pool.awaitTermination(1000L, TimeUnit.SECONDS);
            System.out.println("now,pool.isTerminated=" + pool.isTerminated() + ", state=" + getThreadPoolRunState(pool));
        }
    }
}
