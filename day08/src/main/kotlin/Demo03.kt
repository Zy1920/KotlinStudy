import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) = runBlocking{
    var job=launch{
        println("协程执行前：${Thread.currentThread().name}")
        delay(4000L)
        println("协程执行后:${Thread.currentThread().name}")
    }
    launch {
        Thread.sleep(1000L)
    }
    launch {
        Thread.sleep(2000L)
    }
    launch {
        Thread.sleep(1000L)
    }
    job.join()
}