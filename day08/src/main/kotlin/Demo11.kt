import kotlinx.coroutines.experimental.*

fun main(args: Array<String>) = runBlocking{//主线程
    var job1=launch {
        println("梅小湛爱吃凉皮！~~~")
    }
    var job2=launch (CommonPool){
        println("梅小湛爱吃凉皮！~~~")
    }
    val job3 = launch(Unconfined) {//运行在主线程中
        println("梅小湛爱吃凉皮！~~~")
    }
    var job4=launch (coroutineContext){//运行在父协程的上下文中 当前运行在主线程中
        println("梅小湛爱吃凉皮！~~~")
    }
    val launch = launch(newFixedThreadPoolContext(5, "新线程")) {//自定义线程池执行
        println("梅小湛爱吃凉皮！~~~")
    }
}