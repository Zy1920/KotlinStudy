fun main(args: Array<String>) {
    val person=Person7("陈奕迅",44,"18715096913")
    println(person.phone)
}
class Person7(var name: String,var age:Int){//必须要有的属性
    init {
    println("执行了主构函数")
    }
    var phone=""
    constructor(name: String,age: Int,phone:String):this(name,age){
        this.phone=phone
        println("执行了次构函数")
    }
}