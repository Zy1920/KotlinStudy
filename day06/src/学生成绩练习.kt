fun main(args: Array<String>) {
    var student:Student=
            student{
                name="陈奕迅"
                age=44
                id=727
                sex="男"
                score{
                   chinese=100
                    math=99
                    english=98
                }
            }
    println(student)
}

fun student(block:StudentBuilder.()->Unit):Student{
    var student=StudentBuilder()
    student.block()
    return student.build()
}

fun StudentBuilder.score(block: ScoreBuilder.() -> Unit){
    var socre=ScoreBuilder()
    socre.block()
    this.score=socre.build()
}

data class Student(val name:String?,val age:Int?,val id:Int?,val sex:String?,val score:Score?)
data class Score(val chinese:Int?,val math:Int?,val english:Int?)

class StudentBuilder{
    var name:String?=null
    var age:Int?=null
    var id:Int?=null
    var sex:String?=null
    var score:Score?=null
    fun build():Student{
        return Student(name,age,id,sex,score)
    }
}

class ScoreBuilder{
    var chinese:Int?=null
    var math:Int?=null
    var english:Int?=null
    fun build():Score{
       return  Score(chinese,math,english)
    }
}