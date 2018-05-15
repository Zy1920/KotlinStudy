import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

//协程的取消
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