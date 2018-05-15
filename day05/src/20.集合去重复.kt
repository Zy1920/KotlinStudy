fun main(args: Array<String>) {
    val list = listOf("张三","李四","王五","赵六","张四","李五","张三","李六")
    var result1=list.distinct()
    println(result1)

    var result2=list.distinctBy {
        it.substring(0,1)
    }
    println(result2)
}