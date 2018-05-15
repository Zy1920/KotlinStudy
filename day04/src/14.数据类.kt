import java.rmi.activation.ActivationDesc
import java.util.*

fun main(args: Array<String>) {
    val news=News("标题","简介","路径","内容")
    println(news.title)
    println(news.content)

    //解构
    val (title,desc,imgPath,content)=News("标题","简介","路径","内容")
    println(title)
    println(content)
}

data class News(var title:String,var desc: String,var imgPath:String,var content:String)