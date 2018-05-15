fun main(args: Array<String>) {
    val list = listOf("张三", "李四", "王五", "赵六", "张四", "李五", "李六")
    //姓张的一组 姓李的一组 其他一组
    //fun <T, K> Iterable<T>.groupBy(keySelector: (T) -> K): Map<K, List<T>>
    //groupBy方法传入的是一个匿名函数，函数传入参数为当前集合，返回一个值，方法的返回值是一个以函数返回值为键，以满足条件的对象为值的map集合
    var result=list.groupBy {
        var first=it.substring(0,1)
        when(first){
            "张"->"张"
            "李"->"李"
            else->"其他"
        }
    }
    println(result)
}