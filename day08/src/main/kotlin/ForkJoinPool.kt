import java.util.concurrent.ForkJoinPool

fun main(args: Array<String>) {
    println("梅小湛爱吃凉皮！~~~")
    //普通线程池 主线程执行结束之后 可以继续执行;ForkJoinPool 主线程执行完之后 ForkJoinPool里面的线程也结束了
    //普通的线程池创建的用户线程 ,ForkJoinPool创建的是守护线程
    //常规的线程池流程
    /*var service=Executors.newFixedThreadPool(3)
    var runnable=MyRunnable()
    service.execute(runnable)*/

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
