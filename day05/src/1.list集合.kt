fun main(args: Array<String>) {
    //1.listOf
    val list1= listOf("张三","李四","王五",23)
    for (any in list1) {
        println(any)
    }
    //2.mutablelistOf
    val list2= mutableListOf("张三","李四","王五",23,"赵六")
    list2.set(2,"陈奕迅")
    list2.add("锅子")
    list2.removeAt(0)
    list2.forEach {
        println(it)
    }
    //3.java的集合 arraylistOf
    val list3= arrayListOf("陈奕迅","haha","eason's life",2018)
    list3.forEach {
        println(it)
    }
}
