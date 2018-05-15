## 线程和线程池

### 线程

- 进程：一个启动的应用程序；线程：系统中最小的执行单元。
- 线程的创建：两种方式，直接通过Thread或者通过Runanble
- 线程安全问题出现的原因：是否是多线程，是否有共享数据，是否是多语句操作共享数据；解决方案：同步代码块。
- 买票案例回顾：

```java
public class Test {
    public static void main(String[] args) {
        //如果线程间要共享数据的话就需要通过Runnable接口定义Thread
        TicketRunnable runnable=new TicketRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
```

```java
public class TicketRunnable implements Runnable {
    private int ticket=100;
    @Override
    public void run() {
        while (true){
            synchronized (TicketRunnable.class){//线程安全问题
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
```



### 线程join

- 普通线程的执行是没有顺序的，所有线程并行执行；当某个线程使用join()方法加入到另一个线程时，另一个线程会等待该线程执行完毕后再继续执行，相当于把线程的并行执行，变成了串行执行。示意图如下：

![](D:/studyImg/tu13.png)

![](D:/studyImg/tu14.png)

```java
public class Test {
    public static void main(String[] args) {
        //普通线程，执行没有顺序 并行执行
        System.out.println("主线程开始执行啦");
        MyThread thread=new MyThread();
        thread.start();
        try {
            //join  必须要等到当前线程执行结束 才能结束  相当于把线程的并行执行 变成了串行执行
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行结束啦~");
    }
}
```



### 守护线程

- 线程分为用户线程和守护线程，用户线程  主线程执行结束 用户线程可以继续执行；守护线程是指在程序运行的时候在后台提供一种通用的服务的线程(垃圾回收线程)，**主线程执行结束，守护线程就结束**。

```java
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
```



### 线程池

- 程序启动一个线程成本是比较高的,因为它涉及到要与操作系统进行交互.而使用线程池可以很好的提高性能,尤其是当程序中要创建大量生命期很短的线程时,更应该考虑使用线程池。
- **线程池里的每一个线程代码结束后,并不会死亡,而是再次回到线程池中成为空闲状态,等待下一个对象来使用**
- 在JDK5之前,我们需要自己手动实现自己的线程池,从JDK5开始,java内置支持线程池
- java中线程池开启分为三步：

```java
public class Test {
    public static void main(String[] args) {
        System.out.println("主线程开始执行啦！~~~");
        //1.创建线程池
        ExecutorService service=Executors.newFixedThreadPool(3);
        //2.创建runnable对象，
        MyRunnable runnable=new MyRunnable();
        //3.开启线程池，可以通过execute执行 执行对象就是Runnable对象
        service.execute(runnable);
        service.execute(runnable);
        service.execute(runnable);
        service.execute(runnable);
        service.execute(runnable);
        service.execute(runnable);
        service.execute(runnable);////线程池线程执行完成之后比并没有走销毁流程 而是回到线程池中 成为初始状态 等待下次执行
        System.out.println("主线程执行结束啦！~~~");
    }
}
```



## 协程

### 协程的创建

- 1.创建gradle工程；2.添加协程的依赖；3.创建协程：**协程启动通过launch函数创建**；

```kotlin
fun main(args: Array<String>) {
    println("梅小湛爱吃凉皮！~~~")
    //开启协程
    launch {
        (1..10).forEach {
            println("打印了$it")
            Thread.sleep(1000L)//睡眠1s
        }
    }
    println("梅小湛最后变成了凉皮！~~~")
    //主线程睡眠6s
    Thread.sleep(6000L)
}
```

- launch的参数和返回值：

  ```
  public actual fun launch(
      context: CoroutineContext = DefaultDispatcher,
      start: CoroutineStart = CoroutineStart.DEFAULT,
      parent: Job? = null,
      block: suspend CoroutineScope.() -> Unit
  ): Job
  ```

  - launch是一个函数，协程需要通过launch函数启动，launch的前三个参数都是默认参数，参数值可以不指定；最后一个参数是函数类型，调用的时候通过lambda表达式去接收；launch函数的返回值是Job类型，就是携程的任务。

- launch函数的第一个参数context：协程上下文

  - context：CoroutineContext = DefaultDispatcher；
  - context类型是CoroutineContext，默认值就是DefaultDispatcher；
  - DefaultDispatcher就是CommonPool，第一个参数默认情况下就是赋值为CommonPool；
  - CommonPool实现原理是通过ForkJoinPool实现的；
  - ForkJoinPool是什么东西?**ForkJoinPool就是线程池，协程其实也是在线程里面执行，第一个参数就是指定协程执行在哪个线程或者线程池**

- **ForkJoinPool：普通的线程池创建的用户线程 ,ForkJoinPool创建的是守护线程；普通线程池主线程执行结束之后可以继续执行，ForkJoinPool 主线程执行完之后 ForkJoinPool里面的线程也结束了**。

```kotlin
fun main(args: Array<String>) {
    println("梅小湛爱吃凉皮！~~~")
    //普通线程池 主线程执行结束之后 可以继续执行;ForkJoinPool 主线程执行完之后 ForkJoinPool里面的线程也结束了
    //普通的线程池创建的用户线程 ,ForkJoinPool创建的是守护线程
    //常规的线程池流程
    /*var service=Executors.newFixedThreadPool(3)
    var runnable=MyRunnable()
    service.execute(runnable)*/
	//ForkJoinPool线程池流程
    var service=ForkJoinPool(3)
    var runnable=MyRunnable()
    service.execute(runnable)
    Thread.sleep(2000L)
    println("梅小湛最后变成了凉皮！~~~")
}
class MyRunnable:Runnable{
    override fun run() {
        (1..10).forEach {
            println("打印了$it")
            Thread.sleep(500L)
        }
    }
}
```

- 协程启动后的处理：根据上边的分析可知，launch启动的协程是守护线程，主线程结束后，协程也将结束，故要想让协程正常运行，有哪些处理方法呢：
  - 解决方案1：主线程睡眠
  - 解决方案2：**通过协程返回的Job任务执行join方法(main runblocking)**

```kotlin
fun main(args: Array<String>)= runBlocking{
    println("梅小湛爱吃凉皮")
    var job=launch {
        (1..10).forEach {
            println("打印了$it")
            Thread.sleep(500L)
        }
    }
    println("梅小湛最后变成了凉皮")
    //Thread.sleep(5000L) //解决方案1：主线程睡眠
    job.join()//解决方案2：将协程加入到主线程中，通过调用协程返回值的join方法
}
```



### 协程原理和优势

- 协程的优势：**异步执行，非阻塞**。
- 同步和异步，阻塞与非阻塞的理解：

![](D:/studyImg/15.png)

![](D:/studyImg/16.png)

![](D:/studyImg/17.png)

![](D:/studyImg/18.png)

![](D:/studyImg/19.png)

- **协程的原理：可以把耗时任务先挂起，等时间到了再从线程池中空闲的线程执行，必须是挂起函数才能挂起。**
- **挂起函数：可以被挂起执行,到时间之后从线程池中空闲的线程中恢复执行;挂起函数必须通过suspend进行修饰; 挂起函数必须在协程中执行 ，或者在其他挂起函数中执行。**如下例所示，delay和task均为挂起函数。线程delay之后执行的仍为同一个线程。

```kotlin
fun main(args: Array<String>)= runBlocking {
    var job=launch{
        task()
    }
    job.join()
}
suspend fun task(){
    println(Thread.currentThread().name)
    delay(2000L)//挂起函数
    println(Thread.currentThread().name)
}
```

- 协程与线程效率对比,如下例所示，执行同样的命令，线程耗时301，协程耗时38，可见协程效率明显高于线程。

```kotlin
fun main(args: Array<String>) = runBlocking{
    //线程执行
    /*val starttime=System.currentTimeMillis()
    val threadlist=List(1000){
        MyThread()
    }
    threadlist.forEach {
        it.start()
    }
    threadlist.forEach {
        it.join()
    }
    val endtime=System.currentTimeMillis()
    val time=endtime-starttime
    println("线程耗时$time")*///301

    //协程执行
    val starttime1=System.currentTimeMillis()
    val coroutinesList = List(1000){
        launch {
            println("..")
        }
    }
    coroutinesList.forEach {
        it.join()
    }
    val endtime1=System.currentTimeMillis()
    val time1=endtime1-starttime1
    println("协程耗时为$time1")//38
}

class MyThread:Thread(){
    override fun run() {
        println("..")
    }
}
```



### 协程的操作

- 协程的定时取消

  - 方式一：先使用delay为协程的停止定时，再执行job.cancle取消协程。

  ```kotlin
  fun main(args: Array<String>) = runBlocking{
      var job=launch {
          (1..10).forEach {
              println("梅小湛爱吃凉皮！~~~")
              delay(500L)
          }
      }
      delay(2000L)//定时2s钟，停止协程
      job.cancel()//取消协程
      job.join()
  }
  ```

  - 方式二：在协程执行前调用timeWithout方法，定时取消掉协程。

  ```kotlin
  fun main(args: Array<String>) = runBlocking{
      var job= launch {
          withTimeout(2000L){
              (1..10).forEach {
                  println("梅小湛爱吃凉皮！~~~")
                  delay(500L)
              }
          }
      }
      job.join()
  }
  ```

- 协程的定时取消失效：以上两种方式只能取消掉挂起函数，不能取消阻塞的Thread.sleep方法。

```kotlin
fun main(args: Array<String>) = runBlocking{
    var job= launch {
        (1..10).forEach {
            println("梅小湛爱吃凉皮！~~~")
            Thread.sleep(500L)
        }
    }
    delay(2000L)//定时2s钟，停止协程
    job.cancel()//取消协程//取消挂起，不能取消阻塞的Thread.sleep
    job.join()
}
```

- 协程启动：launch启动协程,不能获取协程执行的结果；async可以获取协程中执行的结果

```kotlin
fun main(args: Array<String>) = runBlocking{
    // 第一中启动协程方式:launch 没有返回值
    //第二种启动协程方式:async 需要返回值就是用async
    var job= launch{
        job1()
    }
    println(job)//不能打印结果，无返回值

    /*var job1=async{job1()}
    var job2= async { job2() }
    var result1=job1.await()//执行完协程之后才能获取到数据
    var result2=job2.await()
    println(result1)
    println(result2)*/
}
suspend fun job1():String{
    println("开始执行job1")
    delay(1000L)
    println("执行了job1")
    return "job1"
}
suspend fun job2():String{
    println("开始执行job2")
    delay(1000L)
    println("执行了job2")
    return "job2"
}
```

- 协程上下文：launch函数第一个参数即协程上下文，指定了指定协程代码在哪个线程池中运行，默认是通过Commpool实现的。
  - Unconfined:无限制运行在主线程中
  - coroutineContext:使用父协程的上下文
  - CommonPool:默认就是CommonPool
  - 自定义线程池上下文:newFixedThreadPoolContext

```kotlin
fun main(args: Array<String>) = runBlocking{//主线程
    var job1=launch {//默认执行在CommonPool中
        println("梅小湛爱吃凉皮！~~~")
    }
    var job2=launch (CommonPool){//指定执行在CommonPool中
        println("梅小湛爱吃凉皮！~~~")
    }
    val job3 = launch(Unconfined) {//运行在主线程中
        println("梅小湛爱吃凉皮！~~~")
    }
    var job4=launch (coroutineContext){//运行在父协程的上下文中 当前运行在主线程中
        println("梅小湛爱吃凉皮！~~~")
    }
    val launch = launch(newFixedThreadPoolContext(5, "新线程")) {//自定义线程池执行
        println("梅小湛爱吃凉皮！~~~")
    }
}
```



