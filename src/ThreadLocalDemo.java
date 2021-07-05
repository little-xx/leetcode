public class ThreadLocalDemo {

    static class ThreadA implements Runnable {

        private ThreadLocal<String> threadLocal;

        public ThreadA(ThreadLocal<String> threadLocal) {
            this.threadLocal = threadLocal;
        }

        @Override
        public void run() {
            threadLocal.set("A");
            System.out.println("Thread A : " +  threadLocal.get());
        }
    }

    static class ThreadB implements Runnable {

        private ThreadLocal<String> threadLocal;

        public ThreadB(ThreadLocal<String> threadLocal) {
            this.threadLocal = threadLocal;
        }

        @Override
        public void run() {
            threadLocal.set("B");
            System.out.println("Thread B : " + threadLocal.get());
        }
    }

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        new Thread(new ThreadA(threadLocal)).start();
        new Thread(new ThreadB(threadLocal)).start();
    }
}
