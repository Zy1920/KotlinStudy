fun main(args: Array<String>) {
    println(add(1, 2, 4, 5, 6, 3, 2, 45))
}
fun add(vararg a:Int):Int{
    var sum=0
    for (i in a) {
        sum+= i
    }
    return sum
}