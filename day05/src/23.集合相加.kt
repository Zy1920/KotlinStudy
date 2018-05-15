fun main(args: Array<String>) {
    val list = listOf(Person("林青霞",50),Person("张曼玉",30),Person("柳岩",70))
    //将集合中所有人年龄相加
    var result= list.sumBy {
        it.age
    }
    println(result)
}