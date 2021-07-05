package concurrency;

public class test {

    public static void main(String[] args) throws InterruptedException {
        SharedMapWithUserContext firstContext = new SharedMapWithUserContext(1);
        SharedMapWithUserContext secondContext = new SharedMapWithUserContext(2);

        new Thread(firstContext).start();
        new Thread(secondContext).start();

        Thread.sleep(500);
        System.out.println(SharedMapWithUserContext.userContextPerUserId.size());
    }
}
