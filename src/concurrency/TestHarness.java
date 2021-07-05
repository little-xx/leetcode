package concurrency;

import java.util.concurrent.CountDownLatch;

public class TestHarness {

    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) { }

                }
            };
            t.start();
        }

        long start = System.nanoTime();
        System.out.println(start);
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        System.out.println(end);
        System.out.println("cost time : " + (end - start));
        return end - start;
    }
}
