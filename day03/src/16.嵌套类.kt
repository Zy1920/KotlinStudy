fun main(args: Array<String>) {
    val inclass=outClass.innerClass()
    inclass.sayhello()
}
class outClass{
    val name="张三"
    class innerClass{
        fun sayhello(){
            println("sayhello to haha")
        }
    }
}