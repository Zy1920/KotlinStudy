import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) = runBlocking{
    var job= launch {
        (1..10).forEach {
            println("梅小湛爱吃凉皮！~~~${Thread.currentThread().name}")
            Thread.sleep(500L)
        }
    }
    delay(2000L)//定时2s钟，停止协程
    job.cancel()//取消协程//取消挂起  不能取消阻塞的Thread.sleep
    job.join()
}