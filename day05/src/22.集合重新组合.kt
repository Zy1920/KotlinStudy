fun main(args: Array<String>) {
    val list1 = listOf(Person("林青霞",50),Person("张曼玉",30),Person("柳岩",70))
    //将Person里面每一个name获取
    println(list1.map {
        it.name
    })
    //获取person里每一个姓氏
    println(list1.map {
        it.name.substring(0, 1)
    })
}