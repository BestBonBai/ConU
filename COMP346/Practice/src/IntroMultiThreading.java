/**
 * @author: Duc Nguyen
 * A simple program with 2 threads: Thread A and Thread B running concurrently
 */

public class IntroMultiThreading {

    public static void main(String[] args) {
        createThreadA();
        createThreadB();
    }

    private static void createThreadB() {
        new ThreadA("A").start();
    }

    private static void createThreadA() {
        new ThreadB(("B")).start();
    }
}
