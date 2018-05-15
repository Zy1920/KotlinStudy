fun main(args: Array<String>) {
    parseType1("haha")
}
inline fun <reified T>parseType1(thing:T){
    //获取传递的thing的class类型
    val name = T::class.java.name
    println(name)
}
