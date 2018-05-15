fun main(args: Array<String>) {
    val age=3
    println(todo(age))
}

fun todo(age:Int):String{
    when(age){
        7-> return "开始上小学了"
        12-> return "开始上中学了"
        15-> return "开始上高中了"
        18-> return "开始上大学了"
        else-> return "开始上社会大学了"
    }
}