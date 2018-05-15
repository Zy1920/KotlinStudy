## day06 DSL

### DSL简介

- DSL(Domain-SpecificLanguage,领域特定语言)指的是专注于特定问题领域的计算机语言；不同于通用的计算机语言(GPL  general purpose language),领域特定语言只用在某些特定的领域；领域可能是某一种产业,保险 教育航空 医疗,也可能是一种方法或技术,比如数据库SQL  html…
- Kotlin中构建DSL，可能用到：扩展函数，中缀调用，带接收者的函数字面值
- DSL只是问题解决方案模型的外部封装,这个模型可能是一个API库,也可能是一个完整的框架；没有具体的标准来区分DSL和普通的API,DSL代码更易于理解，不仅对于开发人员而且对于技术含量较低的人员来说也更易于理解。

### DSL

- 标准类格式

```kotlin
fun main(args: Array<String>) {
    //标准的格式
    val address=Address("深圳市","宝安街道",114)
    val person=Person("陈奕迅",44,address)
}
class Address(var city:String,var street:String,var number:Int)
class Person(var name:String,var age:Int,var address:Address)
```

- 想要实现的格式
```kotlin
fun main(args: Array<String>) {
    //想要的格式
    var person{
        name="陈奕迅"
        age=44
        address{
            city="深圳市"
            street="宝安街道"
            number=114
      }
}
class Address(var city:String,var street:String,var number:Int)
class Person(var name:String,var age:Int,var address:Address)
```

- DSL代码实现

```kotlin
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
```

- 标准html格式代码实现

```kotlin
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
```





### 构建器模型

- 构建器设计模式定义：将一个复杂对象的构建和表示分离开。需要创建第三方类用于该对象的构建，构建完成后转换为该类。
- 构建器模型java代码实现

```java
public class Notification {
    private String title;
    private String content;
    private String img;
    private long time;

    public Notification(Builder builder) {
        this.title = builder.title;
        this.content = builder.content;
        this.img = builder.img;
        this.time = builder.time;
    }
    static class Builder {
        String title;
        String content;
        String img;
        long time;

        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder content(String content) {
            this.content = content;
            return this;
        }
        public Builder img(String img) {
            this.img = img;
            return this;
        }
        public Builder time(long time) {
            this.time = time;
            return this;
        }
        public Notification build() {
            return new Notification(this);
        }
    }
}
```

```java
public class Test {
    public static void main(String[] args) {
        Notification noti=
                new Notification
                        .Builder()
                        .title("陈奕迅")
                        .content("爱生活爱陈奕迅！~~~")
                        .img("图片")
                        .time(876L)
                        .build();
    }
}
```

- 构建器模型kotlin代码实现:实现的功能：Person对象只能被赋值一次，后边不能再修改了，address对象只能被赋值一次，后边不能再修改了；同时实现了有多个地址值。

```kotlin
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
```



### DSL缩小作用域

- @DSLMarker

  annotation class MYTAG声明

  在需要定义作用域的类前标注@MYTAG即可。

- MYTAG为自定义名，其余为固定格式。




### 课后练习-学生成绩DSL代码实现

```kotlin
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
```

