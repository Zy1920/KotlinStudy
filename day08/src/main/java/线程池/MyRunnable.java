package 线程池;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <10; i++) {
            System.out.println(Thread.currentThread().getName()+"线程打印了"+i);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
