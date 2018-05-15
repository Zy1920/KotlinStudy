package com.itcast.day06.dslclass

fun main(args: Array<String>) {
    var oneperson: Person =
            person{
                name="陈奕迅"
                age=44
                address{
                    city="深圳市"
                    street="宝安街道"
                    number=114
                }
            }
    println(oneperson)

}
//第一步：创建一个person高阶函数，传入的是一个函数，高阶函数返回的是Person对象
fun person(block: Person.()->Unit): Person {//第二步：Person.()->Unit为带接收者的函数字面值，作用：修改Person类中的字段name，age等等
    //第三步：创建一个Person对象，并返回该对象
    var person= Person()
    //第四步：执行block方法
    person.block()
    return person
    //return Person().apply(block)
}
//第五步：创建一个address高阶函数，传入的是一个函数，无返回值
fun Person.address(block:Address.()->Unit){//第六步：将lambda表达式改成带接收者的函数字面值，作用：修改Address类中的字段city，street，number等等
    //第八步：执行address的block函数，修改Address类中的字段
    var address=Address()
    address.block()
    //第七步：将address函数定义成Person类的扩展函数，将Address类赋值给Person类中的address字段
    this.address=address
    //this.address=Address().apply(block)
}

data class Address(var city:String?=null,var street:String?=null,var number:Int?=null)
data class Person(var name:String?=null,var age:Int?=null,var address:Address?=null)