import concurrency.PlusOneHundred;
import concurrency.TestHarness;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        TestHarness testHarness = new TestHarness();
        testHarness.timeTasks(100, new PlusOneHundred());
    }

}
