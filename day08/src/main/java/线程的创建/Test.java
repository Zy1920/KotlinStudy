package 线程的创建;

public class Test {
    public static void main(String[] args) {
        /*MyThread thread=new MyThread();
        thread.start();
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+"打印了数字"+i);
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        //如果线程间要共享数据的话就需要通过Runnable接口定义Thread
        TicketRunnable runnable=new TicketRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
