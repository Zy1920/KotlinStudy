#Kotlin基础

###什么是Kotlin
- Kotlin是Jetbrains公司发布的一门基于JVM的编程语言
- Jetbrains是做编译器起家的公司,总部捷克,有圣彼得堡和美国分部
- Jetbrains官网地址：  https://www.jetbrains.com/
- Jetbrains公司最有名的软件：IDEA

###Kotlin的发展
- Android第一开发语言
- Springboot2.0第一开发语言

###为什么要使用Kotlin
- 1、简洁（数据类、扩展方法、区间）
- 2、空值安全（针对空值处理的运算符）
- 3、100%兼容java
- 4、函数式编程 （java中JDK1.8之后有lambda表达式）
- 5、协程，类似与java中的线程
- 6、DSL（领域特定语言），使我们的代码更加简洁清晰

###Kotlin的前景
- 1.Kotlin script(gradle) .kts
- 2.Java虚拟机应用 Web  kotlinee Javafx  JDK1.8之后
- 3.前端开发  kotlinjs  html+css+js
- 4.Android开发
- 5.支持开发ios    oc  swift
- 6.kotlin  Native程序 (完全抛弃JVM虚拟机)
- 全栈工程师

###Kotlin和java虚拟机
![](D:/studyImg/tu11.png)

- java程序运行过程：.java文件（java源文件）通过java编译器编译成.class文件（字节码文件），字节码文件再通过java解释器解释成计算机能读懂的语言，在计算机中运行
- Kotlin程序运行过程：.kt文件（kotlin源文件）通过kotlin编译器编译成Kt.class文件（kotlin字节码文件），字节码文件再通过java解释器解释及Kotlin运行时库，才能在计算机中运行。

###查看kotlin对应的java代码
- 找到kotlin生成字节码（Tools——Kotlin——Show Kotlin ByteCode）
- 字节码对应的java代码（Decompile）

###二进制基础
- 计算机存储数据用二进制存储，N位二进制存储2的N次方种状态

###可变变量和不可变变量
- 可变变量var
- 不可变变量val
- 项目开发中尽量使用val  实在不能使用val再使用var
  -
###变量的定义
- var（val) 变量名：变量数据类型=变量值
  ```kotlin
  var float:Float=12.32f
  ```

###字符串两种定义
- 普通字符串：“hello”
- 原样输出字符串："""hello"""
```kotlin
var place2="""
        |深圳市
        |宝安区
        |留仙二路
    """.trimMargin()
```

###kotlin类型转换
- kotlin数据类型可以通过to方法进行相互转换
- kotlin：最严格的类型检查 java：只能小的赋值给大的 js：最宽松

###字符串
- 字符串删除空格：trim()和trimMargin()
- 字符串比较equals ==和===（equals和==比较的是值，===比较的是地址）
- 字符串切割：split和多条件
```kotlin
val result = str.split(".","-")
```
- 字符串截取
```kotlin
val path = "/Users/yole/kotlin-book/chapter.adoc"
    //获取前6个字符
    println(path.subSequence(0, 6))
    //把第一个r之前的字符截取
    path.substringBefore("r")
    //把最后一个r之前的字符截取
    println(path.substringBeforeLast("r"))
    //把第一个r之后的字符截取
    println(path.substringAfter("r"))
    //把最后一个r之后的字符截取
    println(path.substringAfterLast("r"))
```

###元组数据
- 元祖数据用来给多个变量同时赋值
- 二元元祖Pair（定义：val pair=Pair<数据类型，数据类型>(值1，值2)）
- 二元元组取值（pair.first/pair.second)
- 三元元祖triple(定义：val triple=Triple<数据类型，数据类型，数据类型>(值1，值2，值3))
- 三元元组取值同二元元祖

###空值处理
- ？可空变量类型（val a:Int?=null)
- !!非空断言（var age:String!!=null)
- ?.空安全调用符（age?.toInt())
- ?:Elvis操作符（猫王运算符）(**var ageInt:Int=age?.toInt()?:10**)

###打字交互
- 输出函数：println()
- 输入函数：readLine()

###函数
- 四种函数
- 1.无参无返回值
- 2.无参有返回值
- 3.有参无返回值
- 4.有参有返回值
```kotlin
fun getLength(name: String):Int{
    return name.length
}
```

- 顶层函数
  - java里面函数都需要依赖于对象存在，kotlin中函数不依赖于class类单独存在的函数
- 嵌套函数
  - 函数里面定义的函数
- 无论是顶层函数还是嵌套函数，都需要在**主函数中调用**才能运行

###条件控制语句if
- 精简if/else    if(a>b) return a-b else return b-a
- if语句返回值    return if(a>b) a-b else b-a

###for循环和foreach循环
- for循环的两种写法
  ```kotlin
    val a="avbdfsx"
    for (c in a) {
        println(c)
    }
     for ((index,c) in a.withIndex()) {
        println("index=$index,c=$c")
    }
  ```
- foreach循环的两种写法
  ```kotlin
     a.forEach {
        println(it)
    }

    a.forEachIndexed { index, c ->
        println("index=$index,c=$c")
    }
  ```
###continue和break
- **continue和break只能用在for循环里,不能用在foreach里面**
- continue:跳出本次循环，进入下一次循环
- break:跳出循环
- return:结束本类

###标签处返回
- 标签处返回用于循环嵌套中，跳出指定的循环体
```kotlin
val str1="abcgkgb"
val str2="1234532"
tag1@for (c in str1) {
        tag2@for (d in str2) {
            if(c=='g'&&d=='4'){
                break@tag1
            }
            println("c=$c,d=$d")
        }
    }
```
###while和dowhile循环
— while循环先做判断再执行循环体，dowhile循环先执行一次循环体再进行判断

###区间
- 区间定义的三种方式（以char为例）
```kotlin
val range7='a'..'z'
val range8=CharRange('a','z')
val range9='a'.rangeTo('z')
```

- 区间遍历
  - 区间中每个元素的遍历使用for和foreach循环
  - 对区间做遍历的时候，可用到**step**，用于对指定步数的区间遍历

- 反向区间和区间的反转
- 1.反向区间：downTo
```kotlin
val range=100 downTo 1
```
- 2.区间的反转：.reversed()
```kotlin
val range2=1..10
val range3=range2.reversed()
```
###数组
- 8种基本数据类型的数组可以通过Array创建或者通过自己的数据类型Array(BooleanArray\ByteArray\ShortArray\CharArray\FloatArray\DoubleArray\LongArray)创建，字符串数组只能通过arrayOf创建
```kotlin
val arr3 = arrayOf("张三",10,'a')
```
- 数组的遍历用到for和foreach
- 数组元素的修改有两种方法：指定角标赋值和set方法
```kotlin
var arr1= arrayOf(2,4,2,4,56)
arr1[2]=5
arr1.set(4,57)
```
- 数组元素角标的查找
  - 用到indexOf()、lastIndexOf()、indexOfFirst()、indexOfLast()等方法
```kotlin
fun main(args: Array<String>) {
    val array: Array<String> = arrayOf("张三","李四","王五","张思","张三","赵六")
    //元素第一次出现的角标位置，没有则返回-1
    println(array.indexOf("张三"))
    //元素最后一次出现的角标，没有返回-1
    println(array.lastIndexOf("张三"))
    /*---------------------------高阶函数实现---------------------------*/
    //查找第一个姓张的人的角标
    println(array.indexOfFirst {
        it.startsWith("张")
    })
    //查找最后一个姓张的人的角标
    println(array.indexOfLast {
        it.startsWith("张")
    })
}
```

###when表达式
- when表达式是多分支的条件控制语句
- kotlin里面**when表达式原理**：简单的when表达式通过switch语句实现，复杂的when表达式通过if else来实现
- **when表达式返回值在{}最后一行**  lambda表达式最后一行为返回值

- when表达式
```kotlin
fun todo(age:Int):String{
    when(age){
        7-> return "开始上小学了"
        12-> return "开始上中学了"
        15-> return "开始上高中了"
        18-> return "开始上大学了"
        else-> return "开始上社会大学了"
    }
}
```

- when表达式加强
```kotlin
fun todo(age:Int):String{
    when(age){
    	in 1..6->return "还没上小学呢"
        7-> return "开始上小学了"
        in 8-11->return "在上小学"
        12-> return "开始上中学了"
        in 13..14->return "在上初中"
        15-> return "开始上高中了"
        in 16..17->return "在上高中"
        18-> return "开始上大学了"
        in 19..22->return "在上大学哦"
        else-> return "开始上社会大学了"
    }
}
```
- when表达式不带参数
```kotlin
fun todo(age:Int):String{
    when{
    	age in 1..6->return "还没上小学呢"
        age==7-> return "开始上小学了"
        age in 8-11->return "在上小学"
        age==12-> return "开始上中学了"
        age in 13..14->return "在上初中"
        age==15-> return "开始上高中了"
        age in 16..17->return "在上高中"
        age==18-> return "开始上大学了"
        age in 19..22->return "在上大学哦"
        else-> return "开始上社会大学了"
    }
}
```

- when表达式返回值
```kotlin
fun todo(age:Int):String{
    return when{
    	age in 1..6->"还没上小学呢"
        age==7-> "开始上小学了"
        age in 8-11->"在上小学"
        age==12-> "开始上中学了"
        age in 13..14->"在上初中"
        age==15-> "开始上高中了"
        age in 16..17->"在上高中"
        age==18->"开始上大学了"
        age in 19..22->"在上大学哦"
        else->"开始上社会大学了"
    }
}
```


