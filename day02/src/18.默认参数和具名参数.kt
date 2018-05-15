import java.lang.reflect.Method

fun main(args: Array<String>) {
    sendRequest(method = "SET",path = "www.baidu.com")
}

fun sendRequest(path:String,method:String="GET"){
    println("请求路径=$path,method=$method")
}