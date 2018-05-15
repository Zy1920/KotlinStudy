import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.withTimeout
//协程的取消：方式二
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