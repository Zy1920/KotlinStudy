fun main(args: Array<String>) {
    val xm3=xiaoming2()
    xm3.ride()
    xm3.drive()
}
class xiaoming2:ChHuman(),RideBike2,DriveCar2{
    override var license:String="123453217953"
    override fun ride() {
        println("小明会骑车啦！~~~")
    }
    /*override fun drive() {
        println("小明会开车啦！~~~")
    }*/
}
interface RideBike2{
    fun ride()
}
interface DriveCar2{
    var license:String
    fun drive(){
        println("挂挡，踩油门，走！~~！~")
    }
}