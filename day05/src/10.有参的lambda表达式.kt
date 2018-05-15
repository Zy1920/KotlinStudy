fun main(args: Array<String>) {
    //嵌套有参的lambda表达式  实现a+b的和
 /*   val result={a:Int,b:Int->
        a+b
    }(10,20)*/
    val result={a:Int,b:Int->
        a+b
    }.invoke(10,20)
    println(result)
}