package 线程的创建;

public class TicketRunnable implements Runnable {
    private int ticket=100;
    @Override
    public void run() {
        while (true){
            synchronized (TicketRunnable.class){
                if (ticket>=0){
                    System.out.println(Thread.currentThread().getName()+"线程售出了第"+ticket+"张票");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket--;
                }
            }
        }
    }
}
