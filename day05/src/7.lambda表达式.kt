import java.util.concurrent.ArrayBlockingQueue

fun main(args: Array<String>) {
    var a=20
    var b=40
    var sum=0
    var sub=0
    //只能我用这个工具  不能让其他人用
    //函数的参数定义出来之后 可以自动推断出类型  返回值不需要写 推断出当前的返回值类型
    //匿名函数 lambda表达式
    sum=cacl1(a,b,{m:Int,n:Int->
        m+n
    })//第三个参数是函数的引用
    sub=cacl(a,b,{m:Int,n:Int->
        m-n
    })
    println(sum)
    println(sub)
}
fun cacl1(a:Int,b:Int,block:(Int,Int)->Int):Int{
    return block(a,b)
}