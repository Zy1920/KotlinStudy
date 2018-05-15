fun main(args: Array<String>) {
    val arr1: Array<String> = arrayOf("张三","李四","王五")
    for (s in arr1) {
        println(s)
    }

    val arr2: Array<Any> = arrayOf("张三",20,'a')
    for (any in arr2) {
        println(any)
    }
    arr2.forEachIndexed { index, any ->
        println("index=$index,any=$any")
    }
}