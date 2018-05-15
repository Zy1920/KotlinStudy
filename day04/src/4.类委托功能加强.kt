fun main(args: Array<String>) {
    val smallheadfather2=SmallHeadFather2(smallHeadSon2())
    smallheadfather2.wash()
}
interface washAbility1{
    fun wash()
}
class BigHeadSon2:washAbility1{
    override fun wash() {
        println("大头儿子开始洗碗啦！~~~")
    }
}
class smallHeadSon2:washAbility1{
    override fun wash() {
        println("小头儿子洗碗啦！~~~")
    }
}
class SmallHeadFather2(var washability1:washAbility1):washAbility1 by washability1{
    override fun wash() {
        //付钱
        println("付给小头儿子一块钱")
        //小头儿子洗碗
        washability1.wash()
        //表扬
        println("good job")
    }
}