fun main(args: Array<String>) {
    println(Person2().age)//非静态对象的访问
    println(Person2.name)//静态对象的访问
}
class Person2{
    companion object {
        var name="张三"//静态的name
    }
    var age=20//非静态的age
}