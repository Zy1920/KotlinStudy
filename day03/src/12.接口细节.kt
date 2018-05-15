fun main(args: Array<String>) {
    val xm=xiaoming1()
    println(xm.license)
}
class xiaoming1:ChHuman(),RideBike1,DriveCar1{
    override var license:String="123453217953"
    override fun ride() {
        println("小明会骑车啦！~~~")
    }
    override fun drive() {
        println("小明会开车啦！~~~")
    }
}
interface RideBike1{
    fun ride()
}
interface DriveCar1{
    var license:String
    fun drive()
}