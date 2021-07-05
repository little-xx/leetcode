package concurrency;

public class PlusOneHundred implements Runnable{

    @Override
    public void run() {
        int sum = 1;
        for (int i = 0 ; i < 10000000; i++) {
            sum++;
        }
        System.out.println(sum);
    }
}
