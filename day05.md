## 0day5

### 集合

![](D:/studyImg/tu13.jpg)



- 各类集合的特点

  - Set集合和List集合实现了Collection接口

  - List元素可以重复,Set集合元素不能重复

  - ArrayList线程不安全效率高,Vector线程安全效率低

  - HashMap线程不安全 效率高,HashTable线程安全 ,效率低.

    ​

- kotlin中各种集合的定义和遍历

  - list集合定义：1.listOf(不能添加元素，不能修改元素，只读list集合)  2.mutablelistOf(可变list集合) 3.java的集合arrayListOf;list集合遍历可用for或foreach循环遍历
  - set集合不能存放重复的元素，定义：1.setOf(不可变set集合)  2.mutablesetOf(可变set集合) 3.java的集合treeset等；set集合遍历可用for或foreach循环遍历
  - map集合定义：1.mapOf(不可变map集合) 2.mutablesetof(可变map集合) 3.java的集合hashsetOf；set集合的遍历包括所有的键遍历，所有的值的遍历及所有的键值对的遍历

  ```kotlin
  fun main(args: Array<String>) {
      val map1= mapOf("张三" to 20,"李四" to 12,"陈奕迅" to 24)
      //遍历所有的key
      val keySet=map1.keys
      for (s in keySet) {
          println(s)
      }
      //遍历所有的value
      val value=map1.values
      for (i in value) {
          println(i)
      }
      //遍历所有的key-value键值对
      map1.forEach { t, u ->
          println("key=$t,value=$u")
      }
  }
  ```

  ​

### 函数式编程

- 函数式编程是现代编程语言一个重要的特性JDK1.8，“函数式编程”又称”泛函编程” ,是一种”编程范式”
- 面向对象编程   面向过程编程 函数式编程
- OOP(ObjectOriented Programming)，一切皆对象
- FP(FunctionalProgramming)，一切皆函数
- Kotlin的函数和对象一样都是属于”一等公民”,可以像对象一样作为函数的输入和输出；FP编程是OOP编程的有效补充,不能代替OOP编程



### 高阶函数和lambda表达式

- 闭包：函数不能保存状态，但闭包可以让函数携带状态；对kotlin来说，闭包就是lambda表达式，函数可以作为方法的返回值，函数也可以作为函数的参数。
- 高阶函数：**将函数作为参数或者将函数作为返回值叫做高阶函数**
- 高阶函数示例：cacl函数中第三个参数为函数，故cacl函数称为高阶函数；main函数中高阶函数调用时，对应的第三个参数是函数的引用，函数已经定义好，**函数引用用：：表示**

```kotlin
fun main(args: Array<String>) {
    var a=10
    var b=20
    var sub=0
    var sum=0
    //调用cacl函数传递需要的工具 返回对应的值
    sum= cacl(a,b,::add)//第三个参数是函数的引用
    sub=cacl(a,b,::sub)
    println(sum)
    println(sub)
}
//第三个参数是函数类型 说明kotlin里面的函数可以传递函数参数  如果函数里面传递函数参数的话 就称为高阶函数
fun cacl(a:Int,b:Int,block:(Int,Int)->Int):Int{
    var result=block(a,b)
    return result
}
fun add(a:Int,b:Int):Int{
    return a+b
}
fun sub(a:Int,b:Int):Int{
    return a-b
}
```

- **lambda表达式本质是匿名函数**
- **lambda表达式标准定义：{传入参数：参数类型，传入参数：参数类型...->函数表达式}**

```kotlin
fun main(args: Array<String>) {
    var a=20
    var b=40
    var sum=0
    var sub=0
    //只能我用这个工具  不能让其他人用
    //函数的参数定义出来之后 可以自动推断出类型  返回值不需要写 推断出当前的返回值类型
    //匿名函数 lambda表达式
    sum=cacl1(a,b,{m:Int,n:Int->
        m+n
    })//第三个参数是函数的引用
    sub=cacl(a,b,{m:Int,n:Int->
        m-n
    })
    println(sum)
    println(sub)
}
fun cacl1(a:Int,b:Int,block:(Int,Int)->Int):Int{
    return block(a,b)
}
```

- **lambda表达式去()**:函数调用的时候如果最后一个参数传递的是匿名函数lambda表达式，可以把()前移。
- 上例中的代码可以改写成：

```kotlin
fun main(args: Array<String>) {
    var a=50
    var b=30
    var sum=0
    var sub=0
    sum=cacl2(a,b){m:Int,n:Int->
        m+n
    }//第三个参数应该是函数的引用
    sub=cacl2(a,b){m:Int,n:Int->
        m-n
    }
    println(sum)
    println(sub)
}
//高阶函数 第三个参数是函数参数  最后一个参数是函数参数
fun cacl2(a:Int,b:Int,block:(Int,Int)->Int):Int{
    return block(a,b)
}
```

- 有参和无参的lambda表达式

  - 没有参数的lambda表达式，即嵌套的无参匿名函数，无法通过方法名来调用，只能通过()或.invoke()来调用；

  ```kotlin
  fun main(args: Array<String>) {
      //嵌套的无参匿名函数,不能通过方法名来调用，只能通过()或者.invoke()来调用
      /*{
          println("say hello to me")
      }()*/
      {
          println("say hello to me")
      }.invoke()
  }
  ```

  - 有参的lambda表达式,即嵌套有参的匿名函数，也不能通过方法名调用，通过(参数1，参数2...)或者.invoke(参数1，参数2...)来调用。

  ```kotlin
  fun main(args: Array<String>) {
      //嵌套有参的匿名函数 实现a+b的和
   /*   val result={a:Int,b:Int->
          a+b
      }(10,20)*/
      val result={a:Int,b:Int->
          a+b
      }.invoke(10,20)
      println(result)
  }
  ```

- 保存lambda表达式：用变量接收lambda表达式，之后直接用变量名()或者变量名.invoke()调用即可；**.invoke()支持可空调用。**

- lambda表达式使用：**lambda表达式一般和高阶函数配合使用，高阶函数定义lambda表达式，再在main函数中使用lambda表达式;如果lambda表达式只有一个，可以使用it表示**

```kotlin
fun main(args: Array<String>) {
    //lambda表达式使用的时候如果只有一个参数可以省略参数名,默认是通过it来实现的
    var a=10
    //调用haha函数
    val result=haha1(a,{
        it + 10
    })
    println(result)
}
//高阶函数
fun haha1(m:Int,block:(Int)->Int):Int{
    return block(m)
}
```

- lambda表达式返回值：lambda表达式返回不用return  返回值是最后一行的返回值

```kotlin
fun main(args: Array<String>) {
    //lambda表达式返回不用return  返回值是最后一行的返回值
    var result={
        "haha"
        println("陈奕迅是男神！~~~")
        13
    }
    println(result)
}
```

- 常见的lambda表达式：foreach()和indexOfFirst

```kotlin
fun main(args: Array<String>) {
   /**
     * indexOfFirst 是Array类的扩展函数
     * indexOfFirst参数是函数类型  函数参数类型时数组每一个元素的类型  函数的返回值是boolean类型
     */
    val array= arrayListOf("林青霞","陈奕迅","张三")
    var result=array.indexOfFirst {
        it.startsWith("张")
    }
    println(result)
}
```



### list集合

- 过滤(find和filter)
  - find方法：Iterable<T>.find(predicate: (T) -> Boolean): T?    find 方法中传入的是一个匿名函数，匿名函数传入参数为当前对象，返回值为一个boolean类型的值，方法的返回值是当前对象本身（可空）。
  - filter方法：Iterable<T>.filter(predicate: (T) -> Boolean): List<T>   filter方法传入的是一个匿名函数，匿名函数传入参数为当前对象，返回值是一个boolean类型的值，方法的返回值是一个满足条件的fin对象的集合。
  - filterTo方法：fun <T, C : MutableCollection<in T>> Iterable<T>.filterTo(destination: C, predicate: (T) -> Boolean): C   filterTo方法中传入的是一个集合和一个匿名函数，函数传入参数为当前对象，返回值是一个boolean类型的值，方法的返回值是传入的当前集合。
  - filterIndexed方法：Iterable<T>.filterIndexed(predicate: (index: Int, T) -> Boolean): List<T>   filterIndexed方法传入的是一个匿名函数，函数的传入参数为index和当前对象，函数返回值为一个Boolean类型的值，方法的返回值为满足条件对象的集合

```kotlin
fun main(args: Array<String>) {
    val list = listOf("张三","李四","王五","赵六","张四","李五","李六")
    val list2 = listOf("周芷若","张无忌","张五","李善长","林青霞","李寻欢")
    //    找到第一个姓张的
    //Iterable<T>.find(predicate: (T) -> Boolean): T?
    //find 方法中传入的是一个匿名函数，匿名函数传入参数为当前对象，返回值为一个boolean类型的值，方法的返回值是当前对象本身（可空）
    var result1=list.find {
        it.startsWith("张")
    }
    println(result1)
    //Iterable<T>.filter(predicate: (T) -> Boolean): List<T>
    //filter方法传入的是一个匿名函数，匿名函数传入参数为当前对象，返回值是一个boolean类型的值，方法的返回值是一个满足条件的fin对象的集合。
    //    把第一个集合中所有姓张的找出来
    var result2=list.filter {
        it.startsWith("张")
    }
    println(result2)
    //    把两个集合中所有姓张的找到并存放在同一个集合中
    //fun <T, C : MutableCollection<in T>> Iterable<T>.filterTo(destination: C, predicate: (T) -> Boolean): C
    //filterTo方法中传入的是一个集合和一个匿名函数，函数传入参数为当前对象，返回值是一个boolean类型的值，方法的返回值是传入的当前集合
    val mulList = mutableListOf<String>()
    list.filterTo(mulList){
        it.startsWith("张")
    }
    list2.filterTo(mulList){
        it.startsWith("张")
    }
    println(mulList)
    //    把第一个集合中角标为偶数的元素找出来
    //Iterable<T>.filterIndexed(predicate: (index: Int, T) -> Boolean): List<T>
    //filterIndexed方法传入的是一个匿名函数，函数的传入参数为index和当前对象，函数返回值为一个Boolean类型的值，方法的返回值为满足条件对象的集合
    var result3=list.filterIndexed { index, s ->
        index%2==0
    }
    println(result3)
}
```

- 排序：**正序排序(sorted方法)/倒序排序(sortedDescending方法)/按字段排序(sortedby方法)**

```kotlin
fun main(args: Array<String>) {
    val list = listOf("z","b","d","c")
    //正序
    var result=list.sorted()
    //倒序
    var result2=list.sortedDescending()
    //按字段排序
    val list1= listOf(Person("林青霞",24),Person("张曼玉",13),Person("陈奕迅",44))
    //fun <T, R : Comparable<R>> Iterable<T>.sortedBy(crossinline selector: (T) -> R?): List<T>
    //sortedBy方法中传入的是一个匿名函数，函数传入参数为当前集合，函数返回值为一个比较器，方法的返回值是一个当前对象的集合
    var result3=list1.sortedBy {
        it.age
    }
    println(result3)
    println(list1.sortedByDescending {
        it.age
    })
}
data class Person(var name:String,var age:Int)
```

- 分组：**groupBy方法**

```kotlin
fun main(args: Array<String>) {
    val list = listOf("张三", "李四", "王五", "赵六", "张四", "李五", "李六")
    //姓张的一组 姓李的一组 其他一组
    //fun <T, K> Iterable<T>.groupBy(keySelector: (T) -> K): Map<K, List<T>>
    //groupBy方法传入的是一个匿名函数，函数传入参数为当前集合，返回一个值，方法的返回值是一个以函数返回值为键，以满足条件的对象为值的map集合
    var result=list.groupBy {
        var first=it.substring(0,1)
        when(first){
            "张"->"张"
            "李"->"李"
            else->"其他"
        }
    }
    println(result)
}
```

- 最值:**最大值(max方法)/最小值(min方法)/对象最大值(maxBy方法)/对象最小值(minBy方法)**

```kotlin
fun main(args: Array<String>) {
    val list= listOf("a","b","d","u")
    println(list.max())//最大值
    println(list.min())//最小值

    val list1 = listOf(Person("林青霞",50),Person("张曼玉",30),Person("柳岩",70))
    //对象最大值
    println(list1.maxBy {
        it.age
    })
    //对象最小值
    println(list1.minBy {
        it.age
    })
}
```

- **集合去重复(distinct方法和distinctBy方法)**

```kotlin
fun main(args: Array<String>) {
    val list = listOf("张三","李四","王五","赵六","张四","李五","张三","李六")
    var result1=list.distinct()
    println(result1)

    var result2=list.distinctBy {
        it.substring(0,1)
    }
    println(result2)
}
```

- **集合拆封：partition方法，得到的是一个二元元祖**

```kotlin
fun main(args: Array<String>) {
    val list = listOf("张三","李四","王五","赵六","张四","李五","张三","李六")
    //姓张的一部分，另外的一部分
    var pair=list.partition {
        it.startsWith("张")
    }
    println(pair.first)
    println(pair.second)
}
```

- **集合重新组合：map方法**

```kotlin
fun main(args: Array<String>) {
    val list1 = listOf(Person("林青霞",50),Person("张曼玉",30),Person("柳岩",70))
    //将Person里面每一个name获取
    println(list1.map {
        it.name
    })
    //获取person里每一个姓氏
    println(list1.map {
        it.name.substring(0, 1)
    })
}
```

- **集合相加：sumBy方法**

```kotlin
fun main(args: Array<String>) {
    val list = listOf(Person("林青霞",50),Person("张曼玉",30),Person("柳岩",70))
    //将集合中所有人年龄相加
    var result= list.sumBy {
        it.age
    }
    println(result)
}
```



### 四大函数

- 四大函数除了with之外其他都是扩展函数；Apply(使用this代表当前对象,返回值是当前对象)；*Let(太用it代表当前对象,返回值是表达式最后一行)*；With(使用this代表当前对象,返回值是最后一行)；Run(代码块)。
- apply函数：fun <T> T.apply(block: T.() -> Unit): T 
  - 任意类型都有apply函数扩展 
  - apply参数是一个函数  T.() -> Unit 带接收者的函数字面值 
  - lambda表达式里this代表调用的对象 
  - 在lambda表达式里可以访问对象的方法 
  - apply函数返回值就是调用者本身
- let函数：fun <T, R> T.let(block: (T) -> R): R 
  - 任意对象都有let扩展函数
  - let函数参数也是一个函数
  - 函数参数的传入参数是调用者本身
  - let函数返回值是函数参数的返回值，就是lambda表达式的返回值
- with函数：fun <T, R> with(receiver: T, block: T.() -> R): R 
  - with是独立的函数 ,可以在任意地方调用 
  - with函数需要接收两个参数,第一个参数可以接收任意类型对象；第二个参数是函数参数,并且这个函数参数是带接收者的函数字面值 接收者就是第一个参数 
  - with函数返回值是第二个函数参数的返回值 
  - with函数相当于apply和let的结合
- run函数：fun <T, R> T.run(block: T.() -> R): R 
  - 任意类型都有run扩展函数 
  - run的函数参数是当前对象的函数，接收者是调用者本身 
  - run函数返回值就是函数参数的返回值
- T.()->Unit
  -  lambda相当于定义在T里面的函数,该函数可以访问对象里面的字段或者方法
  -  调用的时候两种方式:1.Data().block()  2.block(Data())

```kotlin
fun main(args: Array<String>) {
    val list:ArrayList<String> = arrayListOf("林青霞","范冰冰","柳岩")
    var result1=list?.apply {
        add("陈奕迅")
        add("周迅")
    }
    var result2=list?.let {
        it.add("张国荣")
        println("爱生活爱陈奕迅")
    }
    var result3=with(list){
        this.add("张国荣")
        println("爱生活爱陈奕迅")
    }
    var result4=list.run {
        this.add("张国荣")
        println("爱生活爱陈奕迅")
    }
    set {
        println(this.name)
        this.haha()
        //this.sayhello()
    }
}
fun set(block:data.()->Unit){
   // data().block()
    block(data())
}
class data{
    var name="张三"
    fun haha(){
        println("爱生活爱陈奕迅！~~~")
    }
    //定义在data里的方法可以直接访问data里的字段和方法
    fun sayhello(){
        haha()//等同于 this.haha()
        name
    }
}
```



### java接口回调

- **接口回调的实现过程：在Mother中定义接口类型；在Mother中创建接口对象,并传递给SuperMarket；在SuperMarket中调用Mother传递的接口对象**


- Mother类代码实现

```java
package java接口回调;
public class Mother{
    public static void main(String[]args){
        SuperMarket superMarket=new SuperMarket();
        superMarket.buySoy(new FeedBack() {
            @Override
            public void feed(Soy soy) {
                System.out.println("买到了"+soy.name+"牌酱油");
                System.out.println("妈妈开始做饭了");
            }
        });
        System.out.println("妈妈开始做蛋糕了");
    }
    //第一步:定义能力:取物品的能力
    interface FeedBack {
        void feed(Soy soy);
    }
    static class Son implements FeedBack{
        @Override
        //第四步:在具有能力的对象方法下进行接收
        public void feed(Soy soy) {
            System.out.println("买到了"+soy.name+"牌酱油");
            System.out.println("妈妈开始做饭了");
        }
    }
}
```

- SuperMarket类代码实现

```java
package java接口回调;
public class SuperMarket {
    //第二步:接收具有能力的接口对象
    public void buySoy(Mother.FeedBack feedBack){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Soy soy=new Soy("海天");
                //第三步:通过接口对象将数据传回去
                feedBack.feed(soy);
            }
        }).start();
    }
}
```

- Soy类代码实现

```java
package java接口回调;
public class Soy{
    String name;
    public Soy(String name){
        this.name=name;
    }
}
```



### kotlin函数回调

- **函数回调：函数代替接口实现对象间通信**


- Mother类代码实现

```kotlin
package kotlin函数回调
fun main(args: Array<String>) {
    var superMarket=SuperMarket()
    //lambda表达式
    superMarket.buySoy{
        println("买到了${it.name}牌酱油")
        println("妈妈开始做菜了！~~~")
    }
    println("做甜点了！~~~")
}
```

- SuperMarket类代码实现

```kotlin
package kotlin函数回调
class SuperMarket {
    //高阶函数
    fun buySoy(block:(Soy)->Unit){
        Thread{
            Thread.sleep(5000L)
            //创建soy对象
            var soy=Soy("海天")
            //返回soy对象
            block(soy)
        }.start()
    }
}
```

- Soy类代码实现

```kotlin
package kotlin函数回调
class Soy(var name: String)
```

