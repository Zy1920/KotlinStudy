fun main(args: Array<String>) {
    /*四大函数除了with之外其他都是扩展函数
    *Apply(使用this代表当前对象,返回值是当前对象)
    *Let(太用it代表当前对象,返回值是表达式最后一行)
    *With(使用this代表当前对象,返回值是最后一行)
    *Run(代码块)
     */

    val list:ArrayList<String> = arrayListOf("林青霞","范冰冰","柳岩")
    /*fun <T> T.apply(block: T.() -> Unit): T
     *任意类型都有apply函数扩展
     * apply参数是一个函数  T.() -> Unit 带接收者的函数字面值
     * lambda表达式里this代表调用的对象
     * 在lambda表达式里可以访问对象的方法
     * apply函数返回值就是调用者本身
     */
    var result1=list?.apply {
        add("陈奕迅")
        add("周迅")
    }
    /*
     *fun <T, R> T.let(block: (T) -> R): R
     * 任意对象都有let扩展函数
     * let函数参数也是一个函数
     * 函数参数的传入参数是调用者本身
     * let函数返回值是函数参数的返回值，就是lambda表达式的返回值
     */
    var result2=list?.let {
        it.add("张国荣")
        println("爱生活爱陈奕迅")
    }

    /**fun <T, R> with(receiver: T, block: T.() -> R): R
     * with是独立的函数 ,可以在任意地方调用
     * with函数需要接收两个参数,第一个参数可以接收任意类型对象；第二个参数是函数参数,并且这个函数参数是带接收者的函数字面值 接收者就是第一个参数
     * with函数返回值是第二个函数参数的返回值
     * 相当于apply和let的结合
     */
    var result3=with(list){
        this.add("张国荣")
        println("爱生活爱陈奕迅")
    }

    /**fun <T, R> T.run(block: T.() -> R): R
     * 任意类型都有run扩展函数
     * run的函数参数是当前对象的函数，接收者是调用者本身
     * run函数返回值就是函数参数的返回值
     */
    var result4=list.run {
        this.add("张国荣")
        println("爱生活爱陈奕迅")
    }

    set {
        println(this.name)
        this.haha()
        //this.sayhello()
    }

}

/**
 * T.()->Unit
 * lambda相当于定义在T里面的函数,该函数可以访问对象里面的字段或者方法
 * 调用的时候两种:1.Data().block()  2.block(Data())
 */

fun set(block:data.()->Unit){
   // data().block()
    block(data())
}

class data{
    var name="张三"
    fun haha(){
        println("爱生活爱陈奕迅！~~~")
    }
    //定义在data里的方法可以直接访问data里的字段和方法
    fun sayhello(){
        haha()//等同于 this.haha()
        name
    }

}