fun main(args: Array<String>) {
    var 助教=Teacher()
    println("助教level=${助教.level},salary=${助教.salary}")
    var 讲师=助教++
    println("讲师level=${讲师.level},salary=${讲师.salary}")
    var 副教授=讲师++
    println("副教授level=${副教授.level},salary=${副教授.salary}")
    var 教授=副教授++
    println("教授level=${教授.level},salary=${教授.salary}")
}
class Teacher{
    var level:Int=1
    var salary:Int= 6000
    operator fun inc():Teacher{
        this.level++
        this.salary+=1000
        return this
    }
}