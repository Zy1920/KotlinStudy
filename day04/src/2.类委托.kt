fun main(args: Array<String>) {
    val smallheadfather=SmallHeadFather()
    smallheadfather.wash()
}
//洗碗的能力接口
interface washPower{
    //洗碗的行为
    fun wash()
}
class BigHeadSon:washPower{
    override fun wash() {
        println("大头儿子开始洗碗啦！~~~")
    }
}
class SmallHeadFather:washPower by BigHeadSon()

