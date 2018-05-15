package 开房数据库

fun main(args: Array<String>) {
    val list = getPersonRepository()
    /*---------------------------- 计算广东省人数 ----------------------------*/
    var result1=list.filter {
        it.province=="广东"
    }
    println(result1.size)

    /*---------------------------- 统计广东省男性人数 ----------------------------*/
   var result2=result1.filter {
       it.sex=="男"
   }
    println(result2.size)

    /*---------------------------- 获取年纪在20到35岁的女性人数 ----------------------------*/
    var result3=list.filter {
        it.sex=="女"&&it.idNum.substring(6,10)>="1998"&&it.idNum.substring(6,10)<="1983"
    }
    println(result3.size)
    /*---------------------------- 2016年2yue13到15开房人信息 ----------------------------*/

    /*---------------------------- 范冰冰在2016年2yue13到15开放人信息 ----------------------------*/

    /*---------------------------- 范冰冰在2016年2yue13到15开放人信息 按照酒店分类 ----------------------------*/

    /*---------------------------- 范冰冰在2016年2yue13到15开放人信息按时间排序 ----------------------------*/

}