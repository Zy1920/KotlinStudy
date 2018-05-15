fun main(args: Array<String>) {
    val chhuman=ChHuman()
    println(chhuman.color)
    println(chhuman.language)
    chhuman.eat()
}
abstract class Human{
    abstract var color:String
    abstract var language:String
    abstract fun eat()
}
open class ChHuman() :Human(){
    override fun eat() {
        println("中国人用筷子吃饭")
    }
    override var color="黄色"
    override var language="中文"
}