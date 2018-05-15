fun main(args: Array<String>) {
    val zi=Zi()
    println(zi.name)
    println(zi.age)
    zi.hobby()
}
open class Fu {
    open var name = "陈奕迅"
    open var age = 44
    open fun hobby(){
        println("父亲最爱唱歌啦！~~~")
    }
}
class Zi:Fu(){
    override var name="陈大大"
    override var age=15
    override fun hobby() {
        println("孩子也最爱唱歌啦！~~~")
    }
}