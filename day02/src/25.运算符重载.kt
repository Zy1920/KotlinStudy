fun main(args: Array<String>) {
    var girl1:Girl=Girl("张三",23)
    var girl2:Girl=Girl("李四",22)
    var newgirl:Int=girl1 + girl2
    println(newgirl)
}
class Girl{
    constructor(name: String,age:Int) {
        this.name = name
        this.age=age
    }
    operator fun plus(girl:Girl):Int{
        return this.age+girl.age
    }
    var name:String
    var age:Int
}