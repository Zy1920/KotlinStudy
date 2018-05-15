fun main(args: Array<String>) {
    var teacher1:Teacher=Teacher(6000)
    //teacher1++
}
class Teacher{
    var wage:Int

    constructor(wage: Int) {
        this.wage = wage
    }

   /* operator fun inc(teacher: Teacher):Int{
        return this.wage+1000
    }*/
}