fun main(args: Array<String>) {
    //保存lambda表达式
    val function:(()->Unit)? = null//可空的函数变量类型
    /*{
        println("hello")
    }*/
    //调用lambda表达式
    //function()
    function?.invoke()//可空函数的调用


}

