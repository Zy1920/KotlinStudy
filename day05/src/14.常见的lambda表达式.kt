fun main(args: Array<String>) {
    /**
     * foreach是一个扩展函数
     * foreach参数是一个函数
     */
    var str="haha"
     /*  str.forEach ({char->
        println(char)
    })*/
    str.forEach {
        println(it)
    }

    /**
     * indexOfFirst 是Array类的扩展函数
     * indexOfFirst参数是函数类型  函数参数类型时数组每一个元素的类型  函数的返回值是boolean类型
     */
    val array= arrayListOf("林青霞","陈奕迅","张三")
    var result=array.indexOfFirst {
        it.startsWith("张")
    }
    println(result)
}