import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
//挂起函数:可以被挂起执行  到时间之后从线程池中空闲的线程中恢复执行
// 挂起函数必须通过suspend进行修饰
// 挂起函数必须在协程中执行  或者在其他挂起函数中执行
fun main(args: Array<String>)= runBlocking {
    var job=launch{
        task()
    }
    job.join()
}
suspend fun task(){
    println(Thread.currentThread().name)
    delay(2000L)
    println(Thread.currentThread().name)
}