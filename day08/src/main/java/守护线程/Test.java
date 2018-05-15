package 守护线程;
public class Test {
    public static void main(String[] args) {
        System.out.println("梅小湛爱吃凉皮！~~~");
        MyThread thread=new MyThread();
        thread.setName("线程1");
        //设置为守护线程  必须在启动前调用；主线程执行结束之后 线程就停止了
        thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("梅小湛最后变成了凉皮！~~~");
    }
}
