fun main(args: Array<String>) {
    //val bigheadson=BigHeadSon1()
    //val smallheadfather=SmallHeadFather1(bigheadson)
    val smallheadfather=SmallHeadFather1(smallHeadSon())
    smallheadfather.wash()
}

interface washAbility{
    fun wash()
}
class BigHeadSon1:washAbility{
    override fun wash() {
        println("大头儿子开始洗碗啦！~~~")
    }
}
class smallHeadSon:washAbility{
    override fun wash() {
        println("小头儿子洗碗啦！~~~")
    }
}
class SmallHeadFather1(var washability:washAbility):washAbility by washability