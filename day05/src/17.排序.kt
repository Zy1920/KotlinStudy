fun main(args: Array<String>) {
    val list = listOf("z","b","d","c")
    //正序
    var result=list.sorted()
    //倒序
    var result2=list.sortedDescending()
    //按字段排序
    val list1= listOf(Person("林青霞",24),Person("张曼玉",13),Person("陈奕迅",44))
    //fun <T, R : Comparable<R>> Iterable<T>.sortedBy(crossinline selector: (T) -> R?): List<T>
    //sortedBy方法中传入的是一个匿名函数，函数传入参数为当前集合，函数返回值为一个比较器，方法的返回值是一个当前对象的集合
    var result3=list1.sortedBy {
        it.age
    }
    println(result3)
    println(list1.sortedByDescending {
        it.age
    })

}

data class Person(var name:String,var age:Int)