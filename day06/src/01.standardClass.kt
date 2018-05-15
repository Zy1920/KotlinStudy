fun main(args: Array<String>) {
    //标准的格式
    val address=Address("深圳市","宝安街道",114)
    val person=Person("陈奕迅",44,address)

    //想要的格式
    /*var person{
        name="陈奕迅"
        age=44
        address{
            city="深圳市"
            street="宝安街道"
            number=114
        }
    }*/
}
class Address(var city:String,var street:String,var number:Int)
class Person(var name:String,var age:Int,var address:Address)