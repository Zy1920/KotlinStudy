import org.omg.PortableInterceptor.INACTIVE

fun main(args: Array<String>) {
    var a=10
    var b=20
    var sub=0
    var sum=0
    //调用cacl函数传递需要的工具 返回对应的值
    sum= cacl(a,b,::add)//第三个参数是函数的引用
    sub=cacl(a,b,::sub)
    println(sum)
    println(sub)
}
//第三个参数是函数类型 说明kotlin里面的函数可以传递函数参数  如果函数里面传递函数参数的话 就称为高阶函数
fun cacl(a:Int,b:Int,block:(Int,Int)->Int):Int{
    var result=block(a,b)
    return result
}
fun add(a:Int,b:Int):Int{
    return a+b
}
fun sub(a:Int,b:Int):Int{
    return a-b
}