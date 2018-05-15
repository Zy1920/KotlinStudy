package com.itcast.day06.dslhtml

import java.lang.StringBuilder

fun main(args: Array<String>) {
    var result: Html =
            html{
                head{
                    title{

                    }
                }
                body{
                    div{

                    }
                }
            }
    println(result)
}
//html高阶函数传入的是一个带接收者的函数字面值，返回值是Html对象。高阶函数中创建Html对象，实现block方法，并返回该Html对象
fun html(block: Html.() -> Unit):Html{
    var html=Html()
    html.block()
    return html
}
//head高阶函数传入的是一个带接收者的函数字面值。高阶函数中创建head对象，实现block函数为字段赋值，同时将该对象传到上一级对象的setTag方法中
fun Html.head(block: Head.() -> Unit){
    var head=Head()
    head.block()
    setTag(head)
}
//body高阶函数传入的是一个带接收者的函数字面值。高阶函数中创建body对象，实现block函数为字段赋值，同时将该对象传到上一级对象的setTag方法中
fun Html.body(block:Body.() -> Unit){
    var body=Body()
    body.block()
    setTag(body)
}
//title高阶函数传入的是一个带接收者的函数字面值。高阶函数中创建title对象，实现block函数为字段赋值，同时将该对象传到上一级对象的setTag方法中
fun Head.title(block: () -> Unit){
    var title=Title()
    setTag(title)
}
//div高阶函数传入的是一个带接收者的函数字面值。高阶函数中创建div对象，实现block函数为字段赋值，同时将该对象传到上一级对象的setTag方法中
fun Body.div(block: () -> Unit){
    var div=Div()
    setTag(div)
}
//创建各个类
class Html:Tag("html")
class Body:Tag("body")
class Head:Tag("head")
class Div:Tag("div")
class Title:Tag("title")
//创建标签父类，父类中有setTag方法，toString方法
open class Tag(var name:String){
    var list=ArrayList<Tag>()
    fun setTag(tag: Tag){
        list.add(tag)
    }
    override fun toString(): String {
        var sb= StringBuilder()
        sb.append("<$name>")
        list.forEach {
            sb.append(it.toString())
        }
       sb.append("</$name>")
        return sb.toString()
    }
}