fun main(args: Array<String>) {
    println(Utils.instance.age)//获取非静态属性，需创建单例对象
    println(Utils.name)//获取静态属性
}
class Utils private constructor(){//私有构造函数
    //非静态的
    var age=20
    companion object {
        //静态的
        var name="张三"
        //instance代表Utils的对象实例
        val instance:Utils by lazy { Utils() }//惰性加载  只会加载一次  线程安全
    }
}