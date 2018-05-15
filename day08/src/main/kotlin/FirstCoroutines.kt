import kotlinx.coroutines.experimental.launch

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
    //主线程睡眠
    Thread.sleep(6000L)
}