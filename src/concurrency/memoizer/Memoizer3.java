package concurrency.memoizer;

import java.util.concurrent.*;

public class Memoizer3<A, V> implements Computable<A, V> {

    private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();

    private final Computable<A, V> c;

    public Memoizer3(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        Future<V> result = cache.get(arg);
        if (result == null) {
            Callable<V> eval = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compute(arg);
                }
            };
            FutureTask<V> ft = new FutureTask<V>(eval);
            result = ft;
            cache.put(arg, result);
            ft.run();
        }
        try {
            return result.get();
        } catch (ExecutionException e) {
            throw new RuntimeException();
        }
    }
}
