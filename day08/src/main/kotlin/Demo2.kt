import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

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