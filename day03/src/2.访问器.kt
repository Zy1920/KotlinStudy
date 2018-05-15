fun main(args: Array<String>) {
    val person=Person2()
    person.name="李四"
}

class Person2{
    var name="张三"
    var age=20
    private set//私有了age的set方法，只能访问不能修改
}