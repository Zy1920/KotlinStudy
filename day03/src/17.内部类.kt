fun main(args: Array<String>) {
    val inclass=outClass1().innerClass()
    inclass.sayhello()
}
class outClass1{
    val name="张三"
    inner class innerClass{
        fun sayhello(){
            println("你好$name")
        }
    }
}