fun main(args: Array<String>) {
    println(name)
    println(name)
}
val name:String by lazy {
    println("初始化了！~~")
    "李四"}