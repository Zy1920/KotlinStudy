import sun.security.util.Length

fun main(args: Array<String>) {
    val rect=rect()
    println(rect.length)
    println(rect.width)
    println(rect.area())
}

class rect{
    var length=100
    var width=90
    fun area():Int{
        return length*width
    }
}