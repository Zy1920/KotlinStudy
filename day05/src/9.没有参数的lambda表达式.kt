fun main(args: Array<String>) {
    //嵌套的无参匿名函数,不能通过方法名来调用，只能通过()或这.invoke()来调用
    /*{
        println("say hello to me")
    }()*/
    {
        println("say hello to me")
    }.invoke()
}