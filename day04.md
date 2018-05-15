## day04

### 中缀表达式

- 中缀表达式的优点：使代码更加简洁易懂


- **中缀表达式用infix关键字修饰**
- 中缀表达式使用条件：
  - 1.必须是成员函数或拓展函数 
  - 2.必须只有用一个参数 
  - 3.参数不能是可变参数或者默认参数

```kotlin
fun main(args: Array<String>) {
    val 李四=Person()
    //李四.sayHello("张三")
    李四 sayHello "张三"
}
class Person{
    infix fun sayHello(name:String){
        println("你好 $name")
    }
}
```



### 类委托

- **类委托实现通过关键字by，将自身的行为委托给具有该行为能力的对象。**
- 类委托实现有两种方式：直接委托给具有某种行为的对象或者委托给具有能实现某种行为的抽象对象。
- 类委托实现方式一：class SmallHeadFather:washPower by BigHeadSon() 小头爸爸直接将洗碗行为委托给具有洗碗能力的大头儿子

```kotlin
fun main(args: Array<String>) {
    val smallheadfather=SmallHeadFather()
    smallheadfather.wash()
}
//洗碗的能力接口
interface washPower{
    //洗碗的行为
    fun wash()
}
class BigHeadSon:washPower{
    override fun wash() {
        println("大头儿子开始洗碗啦！~~~")
    }
}
class SmallHeadFather:washPower by BigHeadSon()
```

- 类委托实现方式二：class SmallHeadFather1(var washability:washAbility):washAbility by washability  （）代表主构函数；小头爸爸将洗碗行为委托给实现了洗碗功能接口的子类对象，解决了实现方式一的委托对象局限性。

```kotlin
fun main(args: Array<String>) {
    //val bigheadson=BigHeadSon1()
    //val smallheadfather=SmallHeadFather1(bigheadson)
    val smallheadfather=SmallHeadFather1(smallHeadSon())
    smallheadfather.wash()
}

interface washAbility{
    fun wash()
}
class BigHeadSon1:washAbility{
    override fun wash() {
        println("大头儿子开始洗碗啦！~~~")
    }
}
class smallHeadSon:washAbility{
    override fun wash() {
        println("小头儿子洗碗啦！~~~")
    }
}
class SmallHeadFather1(var washability:washAbility):washAbility by washability
```

- 类委托功能加强：类实现委托的时候，可以重写功能实现的方法，加强类委托的功能。

```kotlin
fun main(args: Array<String>) {
    val smallheadfather2=SmallHeadFather2(smallHeadSon2())
    smallheadfather2.wash()
}
interface washAbility1{
    fun wash()
}
class BigHeadSon2:washAbility1{
    override fun wash() {
        println("大头儿子开始洗碗啦！~~~")
    }
}
class smallHeadSon2:washAbility1{
    override fun wash() {
        println("小头儿子洗碗啦！~~~")
    }
}
class SmallHeadFather2(var washability1:washAbility1):washAbility1 by washability1{
    override fun wash() {
        //付钱
        println("付给小头儿子一块钱")
        //小头儿子洗碗
        washability1.wash()
        //表扬
        println("good job")
    }
}
```



### 属性委托

- **属性委托就是将字段的get和set方法委托给其他类，属性委托也是通过关键字by**
- 属性委托实例解析：如下例所示，var pmoney:Int by mother()：将大头儿子的压岁钱委托给妈妈；bigheadson.pmoney=1000：调用setValue方法，同时在setValue方法中，输出了mmoney，mmoney不能通过在主函数中重新创建mather对象获得，var pmoney:Int by mother()中已经创建了mather对象； println(bigheadson.pmoney)：调用getValue方法

```kotlin
import kotlin.reflect.KProperty
fun main(args: Array<String>) {
    val bigheadson=bigheadson()
    bigheadson.pmoney=1000//调用setValue方法
    println(bigheadson.pmoney)//调用getValue方法
}
class bigheadson{
    var pmoney:Int by mother()
}
class mother{
    var mmoney=0
    var smoney=0
    operator fun getValue(bigheadson: bigheadson, property: KProperty<*>): Int {
        return smoney
    }
    operator fun setValue(bigheadson: bigheadson, property: KProperty<*>, i: Int) {
        smoney+=50
        mmoney+=i-50
        println(mmoney)
    }
}
```



### 惰性加载和延迟加载

#### 惰性加载

- 对属性字段使用by lazy  eg： val name1:String  by lazy { "张三" }
- 字段只会初始化一次
- by lazy最后一行为返回值
- by lazy是线程安全的

```kotlin
fun main(args: Array<String>) {
    println(name)
    println(name)
}
val name:String by lazy {
    println("初始化了！~~")
    "李四"}
```

#### 延迟加载

- 对属性字段使用lateinit关键字，用的时候再赋值，不赋值则不能用。
- lateinit修饰var可变变量，不能使用在基本数据类型。

```kotlin
fun main(args: Array<String>) {
    val person=Person1()
     person.name="haha"
     println(person.name)
     person.name="gaga"
     println(person.name)
}
class Person1{
    lateinit var name:String
}
```

#### 惰性加载和延迟加载的区别

- by lazy和lateinit都可以单独使用或者放在成员变量中使用
- by lazy知道具体值，用到时候再加载
- lateinit不知道具体值，后面再赋值
- by lazy变量必须通过val修饰，lateinit变量需要通过var修饰

### 扩展函数

- 扩展函数是在不改变已有类的情况下，为类添加新的函数，扩展函数主要是替代java的util类
- 扩展函数实例解析：fun String?.MyisEmpty():Boolean{}为String类的扩展函数，**格式：fun String.扩展函数名**；fun father.sayHello(){}为父类father的扩展函数，son为father子类，创建子类对象后，仍然可以访问父类的扩展函数。
- **扩展函数可以访问当前对象里面的字段和方法**

```kotlin
fun main(args: Array<String>) {
    val str:String?="张三"
    println(str.MyisEmpty())
    val son=son()
    son.sayHello()
}
fun String?.MyisEmpty():Boolean{
    return this?.length==0||this==null
}
fun father.sayHello(){
    println("爸爸打招呼了！~~~")
}
open class father{
    fun haha(){
    }
}
class son:father(){
}
```



### 单例设计模式

- 定义：单例设计模式指内存中只有一个对象实例的一种设计模式。
- java中单例设计模式分为懒汉式设计模式和饿汉式设计模式
- 饿汉式单例设计模式

```java
public class NetUtils {
	//定义一个变量保存NetUitls的实例，用的时候返回。
    private static NetUtils mNetUtils=new NetUtils();
    //1.构造方法私有
    private NetUtils(){}
    //2. 还需要将当前对象的引用传递给外部使用
    public static NetUtils getInstance(){
        return mNetUtils;
    }
}
```

- 懒汉式单例设计模式

```java
public class NetUtils {
   //定义字段复用赋值   用的时候再赋值
    private static NetUtils mNetUtils=null;
    //1.构造方法私有
    private NetUtils(){}
    //2.提供方法返回当前对象的引用
    public static NetUtils getInstance(){
        synchronized (NetUtils.class){//同步代码块，保证线程安全
            //判断是否为空,为空再创建实例对象，不为空直接返回
            if(mNetUtils==null){
                mNetUtils=new NetUtils();
            }
        }
        return mNetUtils;
    }
}
```



### kotlin的object单例

- kotlin中的单例使用关键字object
- object单例中，所有的字段都是static静态，方法不是
- object适用条件：字段不多的时候

```kotlin
fun main(args: Array<String>) {
    //单例调用方法和属性的方式
    println(Utils1.name)
    Utils1.sayHello()
}
//设置成一个单例
object Utils1{
    var name="张三"
    fun sayHello(){
        println("hello,$name")
    }
}
```

- java中可以控制字段是静态还是非静态，static关键字，而kotlin中没有static关键字。
- **伴生对象：用来控制属性的静态，关键字companion**

```kotlin
fun main(args: Array<String>) {
    println(Person2().age)//非静态对象的访问
    println(Person2.name)//静态对象的访问
}
class Person2{
    companion object {
        var name="张三"//静态的name
    }
    var age=20//非静态的age
}
```

#### 实现一个和java一样的单例

- 创建一个和java一样的单例步骤：**1.私有构造函数，用到private constructor();2.创建Utils实例对象： val instance:Utils by lazy { Utils() }，惰性加载且只会加载一次，同时线程安全**。主函数调用Utils属性时，静态属性直接通过类名.属性名调用，非静态属性通过实例对象调用。

```kotlin
fun main(args: Array<String>) {
    println(Utils.instance.age)//获取非静态属性，需创建单例对象
    println(Utils.name)//获取静态属性
}
class Utils private constructor(){//私有构造函数
    //非静态的
    var age=20
    companion object {
        //静态的
        var name="张三"
        //instance代表Utils的对象实例
        val instance:Utils by lazy { Utils() }//惰性加载  只会加载一次  线程安全
    }
}
```



### 枚举

- 枚举就是一一列举

```kotlin
fun main(args: Array<String>) {
    println(WEEK.星期一)
    println(WEEK.星期三)
    println(todo(WEEK.星期六))
}
fun todo(week: WEEK){
    when(week){
        in WEEK.星期一..WEEK.星期五-> println("上班日")
        in WEEK.星期六..WEEK.星期日-> println("休息日")
    }
}
enum class WEEK{
    星期一,星期二,星期三,星期四,星期五,星期六,星期日
}
```

- 枚举加强

```kotlin
fun main(args: Array<String>) {
    println(COLOR.BLUE.r)
    println(COLOR.RED.g)
}
enum class COLOR(var r:Int,var g:Int,var b:Int){
    RED(255,0,0),GREEN(0,255,0),BLUE(0,0,255)
}
```



### 数据类

- 只保存数据，没有其他任何逻辑操作，对应java中的bean类
- **数据类用data关键字修饰**

```kotlin
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
```



### 密封类

- 密封类和枚举差不多，枚举在意数据，密封类更在意类型



