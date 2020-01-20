public class ThreadA extends Thread{
    public ThreadA(String name) {
        setName(name);
    }

    @Override
    public void run() {
        System.out.println("Starting thread " + Thread.currentThread().getName());
        for (int i = 0; i < 10; ++i) {
            System.out.println("Thread A is running at " + i);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Terminating thread " + Thread.currentThread().getName());
    }
}
