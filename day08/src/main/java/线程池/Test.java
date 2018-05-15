package 线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        System.out.println("主线程开始执行啦！~~~");
        //1.创建线程池
        ExecutorService service=Executors.newFixedThreadPool(3);
        //2.创建runnable对象
        MyRunnable runnable=new MyRunnable();
        //3.开启线程池
        service.execute(runnable);
        service.execute(runnable);
        service.execute(runnable);
        service.execute(runnable);
        service.execute(runnable);
        service.execute(runnable);
        service.execute(runnable);
        System.out.println("主线程执行结束啦！~~~");
    }
}
