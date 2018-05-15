fun main(args: Array<String>) {
    parseType(10)
    parseType("我爱陈奕迅哈哈哈！~~~")
    parseType('d')
}
fun <T> parseType(thing:T){//前面定义泛型  后面使用泛型
    when(thing){
        is Int-> println("是整形数据")
        is String-> println("是字符串数据")
        else-> println("无法确定具体类型")
    }
}