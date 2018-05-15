import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
//协程取消失效解决方案：判断isActivie状态  根据这个状态再执行协程的代码
fun main(args: Array<String>) = runBlocking{
    var job= launch {
        (1..10).forEach {
            if(!isActive){
                return@launch//如果协程状态为false，退出协程
            }
            println("梅小湛爱吃凉皮！~~~")
            Thread.sleep(500L)
        }
    }
    delay(2000L)//定时2s钟，停止协程
    println("取消之前状态${job.isActive}")
    job.cancel()//取消协程//取消挂起  不能取消阻塞的Thread.sleep
    println("取消之后状态${job.isActive}")
    job.join()
}