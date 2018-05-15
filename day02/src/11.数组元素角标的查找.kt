fun main(args: Array<String>) {
    val array: Array<String> = arrayOf("张三","李四","王五","张思","张三","赵六")
    //元素第一次出现的角标位置，没有则返回-1
    println(array.indexOf("张三"))
    //元素最后一次出现的角标，没有返回-1
    println(array.lastIndexOf("张三"))
    /*---------------------------高阶函数实现---------------------------*/
    //查找第一个姓张的人的角标
    println(array.indexOfFirst {
        it.startsWith("张")
    })
    //查找最后一个姓张的人的角标
    println(array.indexOfLast {
        it.startsWith("张")
    })
}