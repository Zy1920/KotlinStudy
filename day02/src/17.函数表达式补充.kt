fun main(args: Array<String>) {
    var a=10
    var b=20
    /*val padd=::add3
    println(padd(10, 20))
    println(padd?.invoke(20, 30))*/

    val padd:(Int,Int)->Int={a,b->a+b}
    println(padd(10, 20))
}
fun add3(a:Int,b:Int):Int{
    return a+b
}