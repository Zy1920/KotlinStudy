fun main(args: Array<String>) {
    val person=Person6("陈奕迅",44,"18715096913")
    println(person.phone)
}
class Person6(var name: String,var age:Int){//必须要有的属性
    var phone=""
    constructor(name: String,age: Int,phone:String):this(name,age){
        this.phone=phone
    }
}