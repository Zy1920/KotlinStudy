fun main(args: Array<String>) {
    val person=Person1()
     person.name="haha"
     println(person.name)
     person.name="gaga"
     println(person.name)
}
class Person1{
    lateinit var name:String
}