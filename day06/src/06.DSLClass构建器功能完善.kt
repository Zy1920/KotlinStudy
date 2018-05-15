package com.itcast.day06.dslclass构建器功能完善

/*
想要实现的功能：在前面已经实现了对象只赋值一次的情况下，实现一个person对应多个地址值的功能
 */
fun main(args: Array<String>) {
    var oneperson:Person=
            person{
                name="陈奕迅"
                age=44
                addresses{
                    address{
                        city="深圳市"
                        street="宝安街道"
                        number=114
                    }
                    address{
                        city="厦门市"
                        street="环岛路"
                        number=233
                    }
                }
            }
    println(oneperson)
}
//第一步：创建一个person高阶函数，参数为函数类型，返回值为Person对象
fun person(block:PersonBuilder.()->Unit):Person{
    //第二步：创建personBuilder对象，通过PersonBuilder构建器构建字段
    var person=PersonBuilder()
    //第三步：执行block()方法，为PersonBuilder对象中传递字段
    person.block()
    //第四步：调用PersonBuilder的build方法，将对象转换成Person对象，并返回Person对象
    return person.build()
}

//第五步：创建addresses高阶函数，参数为带接收者的函数字面值
fun addresses(block:ArrayList<Address>.() -> Unit){
    //第六步：创建ArrayList对象
    var list=ArrayList<Address>()
    //第七步：执行block()方法，为ArrayList<Address>对象中传递字段
    list.block()
}

//第八步：创建address高阶函数，参数为带接收者的函数字面值
fun ArrayList<Address>.address(block: AddressBuilder.() -> Unit){
    //第九步：创建AddressBuilder对象，通过AddressBuilder构建器构建字段
    var address=AddressBuilder()
    //第十步：执行block()方法，为对象中传递字段
    address.block()
    //第十步：将AddressBuilder对象转换成Address对象，并添加到list集合中去
    add(address.build())//add方法为集合中的方法，故该高阶函数需定义在ArrayList<Address>集合下，才能直接调用集合中的方法
}

data class Address(val city:String?,val street:String?,val number:Int?)
data class Person(val name:String?,val age:Int?,val address:ArrayList<Address>?)


//定义一个personBuilder类，类中的字段赋值完成后再将其传递给Person对象，实现Person对象一旦创建出来后不可再更改的功能
class PersonBuilder{
    var name:String?=null
    var age:Int?=null
    var address:ArrayList<Address>?=null
    fun build():Person{
        return Person(name,age,address)
    }
}

//定义一个addressBuilder类，类中的字段赋值完成后再将其传递给address对象，实现Address对象一旦创建出来之后不可再更改的功能
class AddressBuilder{
    var city:String?=null
    var street:String?=null
    var number:Int?=null
    fun build():Address{
        return Address(city,street,number)
    }
}