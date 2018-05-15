fun main(args: Array<String>) {
    val sheepherddog:Dog=SheepherdDog()
    if(sheepherddog is SheepherdDog){//判断完之后已将将shepHerdDog类型由Dog类型转换为ShepHerdDog类型
        sheepherddog.herdsheep()
    }
}
abstract class Dog
class SheepherdDog:Dog(){
    fun herdsheep(){
        println("牧羊犬会放羊")
    }
}

