fun main(args: Array<String>) {
    println(COLOR.BLUE.r)
    println(COLOR.RED.g)
}
enum class COLOR(var r:Int,var g:Int,var b:Int){
    RED(255,0,0),GREEN(0,255,0),BLUE(0,0,255)
}