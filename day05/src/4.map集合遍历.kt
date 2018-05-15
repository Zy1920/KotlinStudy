fun main(args: Array<String>) {
    val map1= mapOf("张三" to 20,"李四" to 12,"陈奕迅" to 24)
    //遍历所有的key
    val keySet=map1.keys
    for (s in keySet) {
        println(s)
    }
    //遍历所有的value
    val value=map1.values
    for (i in value) {
        println(i)
    }
    //遍历所有的key-value键值对
    map1.forEach { t, u ->
        println("key=$t,value=$u")
    }
}