fun main(args: Array<String>) {
    val 李四=Person()
    //李四.sayHello("张三")
    李四 sayHello "张三"
}
class Person{
    infix fun sayHello(name:String){
        println("你好 $name")
    }
}