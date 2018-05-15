fun main(args: Array<String>) {
    val person=Person4("陈奕迅",44)
    println(person.name)
    println(person.age)
}
class Person4(name:String,age:Int){
    var name=""
    var age=0
    init {
        this.name=name
        this.age=age
    }
}