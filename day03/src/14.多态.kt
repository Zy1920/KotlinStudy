fun main(args: Array<String>) {
    val cat:animal=cat()
    cat.call()
}
abstract class animal{
    open fun call(){
        println("动物叫")
    }
}
class dog:animal(){
    override fun call() {
        println("狗汪汪叫！~~~")
    }
}
class cat:animal(){
    override fun call() {
        println("猫喵喵叫！~~~")
    }
}