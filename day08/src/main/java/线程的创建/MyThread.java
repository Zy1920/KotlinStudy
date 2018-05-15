package 线程的创建;

public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <9 ; i++) {
            System.out.println(getName()+"打印了数字"+i);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
