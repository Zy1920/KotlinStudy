fun main(args: Array<String>) {
    var a=50
    var b=30
    var sum=0
    var sub=0
    //只能我用这个工具  不能让其他人用
    //函数的参数定义出来之后 可以自动推断出类型  返回值不需要写 推断出当前的返回值类型
    //匿名函数 lambda表达式
    //调用的时候最后一个参数传递的是匿名函数lambda表达式
    //如果最后一个参数是lamba表达式时  可以把()前移
    sum=cacl2(a,b){m:Int,n:Int->
        m+n
    }//第三个参数应该是函数的引用
    sub=cacl2(a,b){m:Int,n:Int->
        m-n
    }
    println(sum)
    println(sub)
}
//高阶函数 第三个参数是函数参数  最后一个参数是函数参数
fun cacl2(a:Int,b:Int,block:(Int,Int)->Int):Int{
    return block(a,b)
}