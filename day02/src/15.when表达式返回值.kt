fun main(args: Array<String>) {
    val age=7
    println(todo3(age))
    //when表达式返回值在{}最后一行  lambda表达式最后一行为返回值
}

fun todo3(age:Int):String{
   return when(age){
        in 1..6->{
            "还没上小学呢"
        }
        7->{
            "开始上小学啦"
            10
            "哈哈哈"
        }
        in 8..11->{
            "在上小学呢"
            "怎么回事儿"
        }
        12->{
            "开始上中学啦"
        }
        13,14->{
            "在上初中呢"
        }
        15->{
            "开始上高中啦"
        }
        16,17->{
            "在上高中呢"
        }
        18->{
            "开始上大学啦"
        }
        in 19..22->{
            "在上大学呢"
        }
        else->{
            "步入社会啦！~~~"
        }
    }
}