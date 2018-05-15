fun main(args: Array<String>) {
    val inclass=outClass2().innerClass()
    inclass.sayhello()
}
class outClass2{
    val name="张三"
    inner class innerClass{
        val name="李四"
        fun sayhello(){
            println("你好${this@outClass2.name}")
        }
    }
}