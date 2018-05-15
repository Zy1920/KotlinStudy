import java.lang.StringBuilder

fun main(args: Array<String>) {
    var html=Html()
    var head=Head()
    var body=Body()
    var div=Div()
    var title=Title()

    //把head放到html中
    html.setTag(head)
    //把body放到html中
    html.setTag(body)
    //把div放到body中
    body.setTag(div)
    //把title放到head中
    head.setTag(title)

    println(html.toString())

}
    class Html:Tag("html")
    class Head:Tag("head")
    class Body:Tag("body")
    class Div:Tag("div")
    class Title:Tag("title")

//任何标签的父类
open class Tag(var name:String){
    var list=ArrayList<Tag>()
    fun setTag(tag:Tag){
        list.add(tag)
    }
    override fun toString():String{
        var sb=StringBuilder()
        sb.append("<$name>")
        list.forEach {
            sb.append(it.toString())
        }
        //还应该有容器保存标签
        sb.append("</$name>")
        return sb.toString()
    }
}

