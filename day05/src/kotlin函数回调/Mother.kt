package kotlin函数回调

fun main(args: Array<String>) {
    var superMarket=SuperMarket()
    //lambda表达式
    superMarket.buySoy{
        println("买到了${it.name}牌酱油")
        println("妈妈开始做菜了！~~~")
    }
    println("做甜点了！~~~")
}