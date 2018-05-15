
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) = runBlocking{
    // 第一中启动协程方式:launch 没有返回值
    //第二种启动协程方式:async 需要返回值就是用async
    var job= launch{
        job1()
    }
    println(job)

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