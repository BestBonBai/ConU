public class ThreadB extends Thread{
    public ThreadB(String name) {
        setName(name);
    }

    @Override
    public void run() {
        System.out.println("Starting thread " + Thread.currentThread().getName());
        for (int i = 0; i<10; ++i) {
            System.out.println("Thread B is running at " + i);
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Terminating thread " + Thread.currentThread().getName() );

    }
}
