fun main(args: Array<String>) {
    //1.不可变map
    val map1= mapOf("张三" to 20,"李四" to 12,"陈奕迅" to 24)
    //2.可变map
    val map2= mutableMapOf("张三" to 20,"李四" to 12,"陈奕迅" to 24)
    map2.put("赵六",23)
    map2.remove("李四")
    //3.java集合
    val map3= hashMapOf("张三" to 20,"李四" to 12,"陈奕迅" to 24)
    map3.get("张三")
    map3.put("赵六",24)
}