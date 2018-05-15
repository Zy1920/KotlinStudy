import kotlinx.coroutines.experimental.runBlocking
fun main(args: Array<String>) = runBlocking{
    //线程执行
    val starttime=System.currentTimeMillis()
    val threadlist=List(100000){
        MyThread()
    }
    threadlist.forEach {
        it.start()
    }
    threadlist.forEach {
        it.join()
    }
    val endtime=System.currentTimeMillis()
    val time=endtime-starttime
    println("线程耗时$time")


    //协程执行
    /*val starttime1=System.currentTimeMillis()
    val coroutinesList = List(100000){
        launch {
            println("..")
        }
    }
    coroutinesList.forEach {
        it.join()
    }
    val endtime1=System.currentTimeMillis()
    val time1=endtime1-starttime1
    println("协程耗时为$time1")//38*/
}

class MyThread:Thread(){
    override fun run() {
        println("..")
    }
}