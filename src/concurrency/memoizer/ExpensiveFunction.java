package concurrency.memoizer;

public class ExpensiveFunction implements Computable<String, Integer> {

    Integer fibonacci(int arg) {
        if (arg == 0) {
            return new Integer("0");
        } else if (arg == 1) {
            return new Integer("1");
        } else {
            return fibonacci(arg - 1) + fibonacci(arg - 2);
        }
    }

    @Override
    public Integer compute(String arg) throws InterruptedException {
        return fibonacci(new Integer(arg));
    }
}
