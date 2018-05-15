fun main(args: Array<String>) {
    val list= listOf("a","b","d","u")
    println(list.max())//最大值
    println(list.min())//最小值

    val list1 = listOf(Person("林青霞",50),Person("张曼玉",30),Person("柳岩",70))
    //对象最大值
    println(list1.maxBy {
        it.age
    })
    //对象最小值
    println(list1.minBy {
        it.age
    })
}