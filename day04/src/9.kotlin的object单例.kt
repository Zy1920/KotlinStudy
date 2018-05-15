fun main(args: Array<String>) {
    //单例调用方法和属性的方式
    println(Utils1.name)
    Utils1.sayHello()
}
//设置成一个单例
object Utils1{
    var name="张三"
    fun sayHello(){
        println("hello,$name")
    }
}