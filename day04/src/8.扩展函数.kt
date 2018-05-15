fun main(args: Array<String>) {
    val str:String?="张三"
    println(str.MyisEmpty())
    val son=son()
    son.sayHello()
}
fun String?.MyisEmpty():Boolean{
    return this?.length==0||this==null
}
fun father.sayHello(){
    println("爸爸打招呼了！~~~")
}
open class father{
    fun haha(){
    }
}
class son:father(){
}