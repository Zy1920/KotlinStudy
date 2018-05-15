fun main(args: Array<String>) {
    var result=test()
    result()
    result()
    result()
}
fun test():()->Unit{
    var a=10
    return {
        println(a)
        a++
    }
}