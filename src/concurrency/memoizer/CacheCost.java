package concurrency.memoizer;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CacheCost {

    private static ExpensiveFunction function = new ExpensiveFunction();

    public static void main(String[] args) throws InterruptedException {
        //String[] array = {"20", "30", "40", "20", "31", "23", "12", "20", "30", "32", "20", "14", "13", "14", "13", "23", "24", "34", "33", "21", "15", "14", "11"};
        String[] array = {"10", "11", "12", "13", "14", "15","16", "17", "18", "19", "20", "21", "22", "23","24", "25", "26","10", "11", "12", "13", "14", "15"};
        //String[] array = {"50"};
        List<String> list = Arrays.asList(array);
        Memoizer2 memoizer1 = new Memoizer2(function);
        CountDownLatch countDownLatch = new CountDownLatch(4);
        long start = System.currentTimeMillis();
        System.out.println("start: " + start);
        for (int i = 0; i < 4; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < list.size(); i++) {
                        try {
                            memoizer1.compute(list.get(i));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    countDownLatch.countDown();
                }
            });
            t.start();
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("end: " + end);
        System.out.println("end - start: " + (end - start));
    }
}
