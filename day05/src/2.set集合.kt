fun main(args: Array<String>) {
    //1.setOf
    val set1= setOf("张三","李四","王五","张三",20,"赵六")
    println(set1.size)
    for (any in set1) {
        println(any)
    }

    //2.mutablesetOf
    val set2= mutableSetOf("张三","李四","王五","张三",20,"赵六")
    set2.add("陈奕迅")
    set2.remove(0)
    for (any in set2) {
        println(any)
    }

    //3.java的set集合
    val set3= hashSetOf("张三","李四","王五","张三",20,"赵六")
    set3.add("陈奕迅")
    set3.remove(3)
    for (any in set3) {
        println(any)
    }
}