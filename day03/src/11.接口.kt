fun main(args: Array<String>) {
    val xm=xiaoming()
    xm.eat()
    println(xm.language)
    println(xm.color)
    xm.drive()
    xm.ride()
}
class xiaoming:ChHuman(),RideBike,DriveCar{
    override fun ride() {
        println("小明会骑车啦！~~~")
    }
    override fun drive() {
        println("小明会开车啦！~~~")
    }
}
interface RideBike{
    fun ride()
}
interface DriveCar{
    fun drive()
}