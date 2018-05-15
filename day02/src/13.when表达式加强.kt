fun main(args: Array<String>) {
    val age=17
    println(todo1(age))
}

fun todo1(age:Int):String{
    when(age){
        in 1..6->{
           return "还没上小学呢"
        }
        7->{
            return "开始上小学啦"
        }
        in 8..11->{
            return "在上小学呢"
        }
        12->{
            return "开始上中学啦"
        }
        13,14->{
            return "在上初中呢"
        }
        15->{
            return "开始上高中啦"
        }
        16,17->{
            return "在上高中呢"
        }
        18->{
            return "开始上大学啦"
        }
        in 19..22->{
            return "在上大学呢"
        }
        else->{
            return "步入社会啦！~~~"
        }

    }
}