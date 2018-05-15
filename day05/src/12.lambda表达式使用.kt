fun main(args: Array<String>) {
    //lambda表达式使用的时候如果只有一个参数可以省略参数名,默认是通过it来实现的
    var a=10
    //调用haha函数
    val result=haha1(a,{
        it + 10
    })
    println(result)
}
//高阶函数
fun haha1(m:Int,block:(Int)->Int):Int{
    return block(m)
}