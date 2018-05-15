fun main(args: Array<String>) {
    var list=ArrayList<Apple3>()
    setFriutList(list)
}
fun setFriutList(list:ArrayList<out Fruit3>){
    println(list.size)
}
abstract class Thing
abstract class Fruit3:Thing()
class Apple3:Fruit3()
class Orange3:Fruit3()