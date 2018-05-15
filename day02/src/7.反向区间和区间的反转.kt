fun main(args: Array<String>) {
    //反向区间
    val range=100 downTo 1
    /*for (i in range) {
        println(i)
    }*/

    //区间的反转
    val range2=1..10
    val range3=range2.reversed()
    for (i in range3) {
        println(i)
    }
}