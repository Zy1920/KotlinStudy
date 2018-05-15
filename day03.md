

## day03

### 函数表达式

- java是声明式语法，无返回值；kotlin是表达式语法，有返回值

- 如果函数是一行表达式，就可以用=连接；如果是多行的语句块，就不能用=连接。

- 对于一个普通的函数：

  ```kotlin
  fun add(a:Int,b:Int):Int{
      return a+b
  }
  ```

  函数体只有一行代码，可以省略{}、省略return，用=连接,上述代码等效于：

  ```kotlin
  fun add(a:Int,b:Int):Int=a+b
  ```

  返回值类型也可以不写,上述代码等效于：

  ```kotlin
  fun add(a:Int,b:Int)=a+b
  ```

- 函数引用

  获取add函数的引用

  ```kotlin
  val padd=::add
  ```

  通过padd调用函数

  ```kotlin
  println(padd(10,20))
  println(padd?.invoke(20,30))//可以处理函数变量为空的情况调用
  ```

- 函数变量

  ```kotlin
  val padd:(Int,Int)->Int={a,b->a+b}//匿名函数
  println(padd(10,20))
  ```

### 函数默认参数和具名函数

- 发送网络请求:path  请求方式GET

- 默认参数:定义函数变量时可以指定默认值

  ```kotlin
  fun sendRequest(path:String,method:String="GET"){
      println("请求路径=$path,method=$method")
  }
  ```

  ​

- 具名参数:调用函数时可以指定参数(没有顺序)

  ```kotlin
   sendRequest(method = "SET",path = "www.baidu.com")
  ```


### 可变参数

- 如果接收的参数个数不确定，可以用可变参数来表示；关键字vararg

  ```kotlin
  fun main(args: Array<String>) {
      println(add(1, 2, 4, 5, 6, 3, 2, 45))
  }
  fun add(vararg a:Int):Int{
      var sum=0
      for (i in a) {
          sum+= i
      }
      return sum
  }
  ```


### 递归

- 递归:把一个大型复杂的问题层层转化为一个与原问题相似的规模较小的问题来求解；只需少量的程序就可描述出解题过程所需要的多次重复计算

- 递归和迭代的对比

  - 常见的需求：通过迭代和递归都可以解决，复杂的问题用递归更容易实现

  - 递归和迭代的各自优缺点

    递归：优点:逻辑比较简单  容易实现  缺点:容易栈内存溢出(内存开销比较大)

    迭代:优点:内存开销小 缺点:抽象出数学模型

- 尾递归优化

  - 尾递归：函数在调用自己之后没有执行其他的任何的操作就是尾递归

  - 只有尾递归才能优化

  - 尾递归优化的原理：将递归转换成迭代

  - 步骤1：需要将递归转换成尾递归 步骤2：加上tailrec
```kotlin
tailrec fun sum1(n:Int,result: Int=0):Int{
    if(n==1){
        return result+1
    }
    else{
        return sum1(n-1,result+n)
    }
}
```

### 异常

- java中异常：编译时异常和运行时异常
- **kotlin中不检查编译时异常**，kotlin认为大部分的编译时异常都是没有必要的

### 面向对象

- 用基本的数据类型描述复杂的事物

  ```kotlin
  fun main(args: Array<String>) {
    val rect=rect()
    println(rect.length)
    println(rect.width)
    println(rect.area())
  }
  class rect{
    var length=100
    var width=90
    fun area():Int{
        return length*width
    }
  }
  ```

  ​

### 运算符重载

- java运算符

  ```kotlin
  算术运算符      +  -  *  /
  自增自减          ++   --	
  关系运算符     ==   !=  >   <   >=   <=
  位运算符	   & | ^ ~ >> <<  >>  >>>
  逻辑运算符   &&  ||  !
  赋值运算符  +=  -=  *=  /=  %=
  其他运算符  xx?xx:xx     instanceof
  ```

- kotlin运算符重载

  - 对于基本运算符（+ - * /)等运算符来说，其实就是一个函数

    ```kotlin
    a + b   a.plus(b)
    a – b   a.minus(b)
    a * b   a.times(b)
    a / b    a.div(b)
    …..

    ```

    ​

  ```kotlin
  fun main(args: Array<String>) {
      var girl1:Girl=Girl("张三",23)
      var girl2:Girl=Girl("李四",22)
      var newgirl:Int=girl1 + girl2
      println(newgirl)
  }
  class Girl{
      constructor(name: String,age:Int) {
          this.name = name
          this.age=age
      }
      operator fun plus(girl:Girl):Int{
          return this.age+girl.age
      }
      var name:String
      var age:Int
  }
  ```

  ​

### 类中的get和set方法

- 对于kotlin成员变量来说,已经默认实现了get和set方法

  ```kotlin
  fun main(args: Array<String>) {
      val person=Person1()
      println(person.age)
      println(person.name)
  }
  class Person1{
      var name="张三"
      var age=12
  }
  ```

- 修改访问器的可见性，kotlin字段是私有的，会自动生成get和set方法，可以使用**private set**修改访问器的可见性

  ```kotlin
  fun main(args: Array<String>) {
      val person=Person2()
      person.name="李四"
      person.age=29//age字段已被私有，能访问但不能被修改了。
  }

  class Person2{
      var name="张三"
      var age=20
     private set//私有了age的set方法，只能访问不能修改
  }
  ```

- 自定义访问器，如下例所示：person类中name字段set方法被私有，age字段set方法是自定义的，满足age不超过150方可设置；age字段的set方法中，用到关键字**field**表示本类的age字段(用this.age会递归造成栈内存溢出)；主函数中创建person类后，age设置成90能设置成功，设置为170不能设置。

  ```kotlin
  fun main(args: Array<String>) {
      val person = Person()
     	person.age = 90
      person.age = 170
      println(person.age)
  }
  //直接访问还是get和set方法
  class Person{
      var name  = "张飒"//只能访问不能修改
          private set//私有了set方法
      var age = 20//age超过150岁不能设置了
          set(value) {
              if(value<150){
  //            this.age = value//age的set方法
                  field = value//age的set方法
              }
          }
  }
  ```

  ​

### 主构函数

- 在 Kotlin 中类可以有一个主构造函数以及多个二级构造函数。主构造函数是类头的一部分：跟在类名后面(可以有可选的类型参数)。

  ```kotlin
  class Person3 constructor (name:String,age:Int){
  }
  ```

- 如果主构造函数没有注解或可见性说明，则 constructor 关键字是可以省略：

  ```kotlin
  class Person3 (name:String,age:Int){
  }
  ```

- 主构造函数不能包含任意代码。根据主构造函数创建出来的对象无法访问内容。初始化代码可以放在以 init 做前缀的初始化块。

  ```kotlin
  fun main(args: Array<String>) {
      val person=Person4("陈奕迅",44)
      println(person.name)
      println(person.age)
  }
  class Person4(name:String,age:Int){
      var name=""
      var age=0
      init {
          this.name=name
          this.age=age
      }
  }
  ```

- 事实上，声明属性并在主构造函数中初始化,在 Kotlin 中有更简单的语法：在主构造函数中的属性可以是可变的( var )或只读的( val )，参数有var修饰,可以使用,可以修改,参数有val修饰，可以使用，不能修改。上述代码等效于：

  ```kotlin
  fun main(args: Array<String>) {
      val person=Person5("陈奕迅",44)
      println(person.name)
      println(person.age)
  }
  class Person5(var name:String,var age:Int){
  }
  ```

  ​

### 二级构造函数

- 类也可以有二级构造函数，需要加前缀 constructor。如果类有主构造函数，每个二级构造函数都要或直接或间接通过另一个二级构造函数代理主构造函数。**在同一个类中代理另一个构造函数使用 this 关键字**：

  ```kotlin
  fun main(args: Array<String>) {
      val person=Person6("陈奕迅",44,"18715096913")
      println(person.phone)
  }
  class Person6(var name: String,var age:Int){//必须要有的属性
      var phone=""
      constructor(name: String,age: Int,phone:String):this(name,age){
          this.phone=phone
      }
  }
  ```

- **无论调用主构还是次构都会执行init**,调用次构先执行init再执行次构中的操作。如下例中，通过次构函数创建对象，主构中的init先执行了再执行次构中的操作。最终输出为：执行了主构函数、执行了次构函数、18715096913

```kotlin
fun main(args: Array<String>) {
    val person=Person7("陈奕迅",44,"18715096913")
    println(person.phone)
}
class Person7(var name: String,var age:Int){//必须要有的属性
    init {
    println("执行了主构函数")
    }
    var phone=""
    constructor(name: String,age: Int,phone:String):this(name,age){
        this.phone=phone
        println("执行了次构函数")
    }
}
```



### 面向对象

- 面向对象三大特征：封装、继承、多态
- 封装：隐藏内部实现的细节，只保留功能接口
- 继承：继承是指一个对象直接使用另一个对象的属性和方法；抽象类反映的是事物的本质，接口反映的是事物的能力
- 多态：同种功能，不同表现形态



### 继承

- **kotlin中的类都是final的，不能被继承**，kotlin中用：表示继承。解决方法——父类用关键字**open**修饰，子类用关键字override修饰

  ```kotlin
  fun main(args: Array<String>) {
      val zi=Zi()
      println(zi.name)
      println(zi.age)
      zi.hobby()
  }
  open class Fu {
      open var name = "陈奕迅"
      open var age = 44
      open fun hobby(){
          println("父亲最爱唱歌啦！~~~")
      }
  }
  class Zi:Fu(){
      override var name="陈大大"
      override var age=15
      override fun hobby() {
          println("孩子也最爱唱歌啦！~~~")
      }
  }
  ```

  ​

### 抽象类

- 抽象类反映的是事物的本质,只能单继承；抽象类也可以继承抽象类
- 抽象类以abstract表示，抽象类可以没有抽象方法和抽象字段
- 抽象类不用open关键字，用**abstract修饰**

```kotlin
fun main(args: Array<String>) {
    val chhuman=ChHuman()
    println(chhuman.color)
    println(chhuman.language)
    chhuman.eat()
}
abstract class Human{
    abstract var color:String
    abstract var language:String
    abstract fun eat()
}
class ChHuman() :Human(){
    override fun eat() {
        println("中国人用筷子吃饭")
    }
    override var color="黄色"
    override var language="中文"
}
```

### 接口

- 抽象类反映事物的本质,接口代表能力；接口用interface定义，用：来实现接口。
- **kotlin中接口与java中接口的区别：java接口中的字段是final修饰的固定值，方法是抽象的；kotlin接口中的字段不能实现，需要在类中重写该字段，kotlin接口中的方法可以实现，无需再在类中实现**；

```kotlin
fun main(args: Array<String>) {
    val xm3=xiaoming2()
    xm3.ride()
    xm3.drive()
}
class xiaoming2:ChHuman(),RideBike2,DriveCar2{
    override var license:String="123453217953"
    override fun ride() {
        println("小明会骑车啦！~~~")
    }
    /*override fun drive() {
        println("小明会开车啦！~~~")
    }*/
}
interface RideBike2{
    fun ride()
}
interface DriveCar2{
    var license:String
    fun drive(){
        println("挂挡，踩油门，走！~~！~")
    }
}
```



### 多态

- 多态表示事物的不同表现形态，特点：通过父类接收，执行的是子类的方法
- 如下例所示：cat对象类型为animal，调用cat的call方法时，调用的是子类cat的方法，而非父类animal的方法。

```kotlin
fun main(args: Array<String>) {
    val cat:animal=cat()
    cat.call()
}
abstract class animal{
    open fun call(){
        println("动物叫")
    }
}
class dog:animal(){
    override fun call() {
        println("狗汪汪叫！~~~")
    }
}
class cat:animal(){
    override fun call() {
        println("猫喵喵叫！~~~")
    }
}
```

- 智能类型转换：kotlin多态中的智能类型转换用到**is关键字做判断并转换成该判断的类型**
- 如下例中，sheepherddog类型为dog类，要想调用SheepherdDog中的herdsheep方法，需要做两部操作：1.判断是否是SheepherdDog；2.转换成SheepherdDog类型。该例中的if方法直接完成了这两步操作。

```kotlin
fun main(args: Array<String>) {
    val sheepherddog:Dog=SheepherdDog()
    if(sheepherddog is SheepherdDog){//判断完之后自己将shepHerdDog类型由Dog类型转换为ShepHerdDog类型
        sheepherddog.herdsheep()
    }
}
abstract class Dog
class SheepherdDog:Dog(){
    fun herdsheep(){
        println("牧羊犬会放羊")
    }
}
```



### 嵌套类和内部类及内部类的使用

- 嵌套类属于静态类，和外部类没有任何关系
- 嵌套类中，嵌套类不能访问外层类中的字段和方法，创建嵌套类对象时，不需要创建外层类对象。

```kotlin
fun main(args: Array<String>) {
    val inclass=outClass.innerClass()
    inclass.sayhello()
}
class outClass{
    val name="张三"
    class innerClass{
        fun sayhello(){
            println("sayhello to haha")
        }
    }
}
```



- 内部类和java的内部类是一样的，需要以来外部类对象的环境。**内部类用Inner修饰**
- **内部类中，内部类可以访问外部类中的字段和方法，创建内部类对象时，需要通过外部类对象.内部类对象来创建。**

```kotlin
fun main(args: Array<String>) {
    val inclass=outClass1().innerClass()
    inclass.sayhello()
}
class outClass1{
    val name="张三"
    inner class innerClass{
        fun sayhello(){
            println("你好$name")
        }
    }
}
```

- 内部类中使用this，this@tag和java里面的OutClass.this.name一样的

```kotlin
fun main(args: Array<String>) {
    val inclass=outClass2().innerClass()
    inclass.sayhello()
}
class outClass2{
    val name="张三"
    inner class innerClass{
        val name="李四"
        fun sayhello(){
            println("你好${this@outClass2.name}")
        }
    }
}
```



### 泛型

- 泛型：在强类型程序设计语言中编写代码时定义一些可变部分
- 定义对象的时候可以使用泛型；定义子类的时候可以使用泛型；定义子类的时候不知道具体类型，继续使用泛型。


```kotlin
fun main(args: Array<String>) {
    val box = Box1<String>("张三")
    println(box.thing)
    val friutbox=FriutBox(Apple())
    println(friutbox.thing)
}
open class Box1<T>(var thing:T)//物品类型不确定，定义泛型和使用泛型
//水果箱子
class FriutBox(thing: Friut):Box1<Friut>(thing)//水果箱子重写箱子
//不知道具体放什么东西的箱子
class sonBox<T>(thing: T):Box1<T>(thing)//
abstract class Friut
class Apple:Friut()
class Orange:Friut()

```

- 泛型函数,**前面定义泛型，后面使用泛型**

```kotlin
fun main(args: Array<String>) {
    parseType(10)
    parseType("我爱陈奕迅哈哈哈！~~~")
    parseType('d')
}
fun <T> parseType(thing:T){//前面定义泛型  后面使用泛型
    when(thing){
        is Int-> println("是整形数据")
        is String-> println("是字符串数据")
        else-> println("无法确定具体类型")
    }
}
```

- 泛型上限：eg：**T:Friut**指泛型只能是Friut类或者Friut类的子类,如下例所示：FriutBox2类设置了泛型上限为Friut，在主函数中创建FriutBox对象时，传入的对象只能是Friut类或者Friut类的子类对象，如thing类不可传入，因为thing类不是Friut类的子类。
- **泛型的作用：1.放任何类型 2.限制存放的类型**

```kotlin
fun main(args: Array<String>) {
    val box = Box2<String>("张三")
    println(box.thing)
    val friutbox=FriutBox2(Apple())
    println(friutbox.thing)
}
open class Box2<T>(var thing:T)//物品类型不确定，定义泛型和使用泛型
class FriutBox2<T:Friut>(thing: T):Box2<T>(thing)
//不知道具体放什么东西的箱子
class sonBox2<T>(thing: T):Box2<T>(thing)//
open class thing
open class Friut1:thing()
class Apple1:Friut()
class Orange1:Friut()
```

- java中必须要通过反射获取泛型类型，kotlin中解决泛型擦除的方法：**1.泛型前加reified关键字；2.方法前加上inline关键字。**T::class.java.name——>获取泛型的class字节码文件类型

```kotlin
fun main(args: Array<String>) {
    parseType1("haha")
}
inline fun <reified T>parseType1(thing:T){
    //获取传递的thing的class类型
    val name = T::class.java.name
    println(name)
}
```

- 泛型类型投射 

  - out：接收当前类型或它的子类，相当于java的？extends
  - in：接收当前类型或者它的父类，相当于java的？super
  - 如下例所示，set方法中传入的参数是Fruit类型的list集合，主函数中需要创建list对象，传入的参数只能是Fruit类型的参数，如果想传入Apple3类（Fruit类的子类），需要把set方法中传入参数Fruit用**out修饰，表示传入参数可以为Fruit类或者Fruit类的子类对象**，如果想传入Thing类（Fruit类的父类），需要把set方法中传入参数Fruit用**in修饰，表示传入参数可以为Fruit类或者Fruit类的父类对象。**

  ```kotlin
  fun main(args: Array<String>) {
      var list=ArrayList<Apple3>()
      setFriutList(list)
  }
  fun setFriutList(list:ArrayList<out Fruit3>){
      println(list.size)
  }
  abstract class Thing
  abstract class Fruit3:Thing()
  class Apple3:Fruit3()
  class Orange3:Fruit3()
  ```

- 泛型星号投射

  - ***可以传递任何类型，相当于java的？**

```kotlin
fun main(args: Array<String>) {
    var list=ArrayList<Int>()
    setFruitLise(list)
}
fun setFruitLise(list: ArrayList<*>){
    println(list.size)
}
```



### 运算符重载练习

- 如下图所示，实现++运算符重载,使得助教++=讲师，讲师++=副教授，副教授++=教授

![](D:/studyImg/tu12.png)

- 代码实现：Teacher类中进行++运算符重载，参数列表是本类，无需传入，返回值类型是本类，运算符重载实现的功能：等级+1，薪资+1000

  ```kotlin
  fun main(args: Array<String>) {
      var 助教=Teacher()
      println("助教level=${助教.level},salary=${助教.salary}")
      var 讲师=助教++
      println("讲师level=${讲师.level},salary=${讲师.salary}")
      var 副教授=讲师++
      println("副教授level=${副教授.level},salary=${副教授.salary}")
      var 教授=副教授++
      println("教授level=${教授.level},salary=${教授.salary}")
  }
  class Teacher{
      var level:Int=1
      var salary:Int= 6000
      operator fun inc():Teacher{
          this.level++
          this.salary+=1000
          return this
      }
  }
  ```

  ​













