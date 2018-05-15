fun main(args: Array<String>) {
    println(WEEK.星期一)
    println(WEEK.星期三)
    println(todo(WEEK.星期六))
}
fun todo(week: WEEK){
    when(week){
        in WEEK.星期一..WEEK.星期五-> println("上班日")
        in WEEK.星期六..WEEK.星期日-> println("休息日")
    }
}
enum class WEEK{
    星期一,星期二,星期三,星期四,星期五,星期六,星期日
}