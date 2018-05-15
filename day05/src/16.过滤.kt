fun main(args: Array<String>) {
    val list = listOf("张三","李四","王五","赵六","张四","李五","李六")
    val list2 = listOf("周芷若","张无忌","张五","李善长","林青霞","李寻欢")
    //    找到第一个姓张的
    //Iterable<T>.find(predicate: (T) -> Boolean): T?
    //find 方法中传入的是一个匿名函数，匿名函数传入参数为当前对象，返回值为一个boolean类型的值，方法的返回值是当前对象本身（可空）
    var result1=list.find {
        it.startsWith("张")
    }
    println(result1)
    //Iterable<T>.filter(predicate: (T) -> Boolean): List<T>
    //filter方法传入的是一个匿名函数，匿名函数传入参数为当前对象，返回值是一个boolean类型的值，方法的返回值是一个满足条件的fin对象的集合。
    //    把第一个集合中所有姓张的找出来
    var result2=list.filter {
        it.startsWith("张")
    }
    println(result2)
    //    把两个集合中所有姓张的找到并存放在同一个集合中
    //fun <T, C : MutableCollection<in T>> Iterable<T>.filterTo(destination: C, predicate: (T) -> Boolean): C
    //filterTo方法中传入的是一个集合和一个匿名函数，函数传入参数为当前对象，返回值是一个boolean类型的值，方法的返回值是传入的当前集合
    val mulList = mutableListOf<String>()
    list.filterTo(mulList){
        it.startsWith("张")
    }
    list2.filterTo(mulList){
        it.startsWith("张")
    }
    println(mulList)
    //    把第一个集合中角标为偶数的元素找出来
    //Iterable<T>.filterIndexed(predicate: (index: Int, T) -> Boolean): List<T>
    //filterIndexed方法传入的是一个匿名函数，函数的传入参数为index和当前对象，函数返回值为一个Boolean类型的值，方法的返回值为满足条件对象的集合

    var result3=list.filterIndexed { index, s ->
        index%2==0
    }
    println(result3)
}