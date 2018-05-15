package com.itcast.day06.dslhtml缩小作用域

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

fun html(block: Html.() -> Unit):Html{
    var html=Html()
    html.block()
    return html
}
//
fun Html.head(block: Head.() -> Unit){
    var head=Head()
    head.block()
    setTag(head)
}
//
fun Html.body(block:Body.() -> Unit){
    var body=Body()
    body.block()
    setTag(body)
}
//
fun Head.title(block: () -> Unit){
    var title=Title()
    setTag(title)
}
//
fun Body.div(block: () -> Unit){
    var div=Div()
    setTag(div)
}

class Html:Tag("html")
class Body:Tag("body")
class Head:Tag("head")
class Div:Tag("div")
class Title:Tag("title")

@MYTAG
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

@DslMarker
annotation class MYTAG
