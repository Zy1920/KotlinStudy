# 什么是groovy

groovy是用于java虚拟机的一种敏捷的动态语言.它是一种成熟的面向对象语言,既可以用于面向对象编程,又可以用作纯粹的脚本语言.使用该语言不必编写过多的代码,同时又具有闭包和动态语言中的其他特性.

- 与java的对比

  - groovy完全兼容java语法
  - 分号是可选的
  - 类 方法默认是public的
  - 编译器自动给属性添加getter/setter方法
  - 属性可以直接用点号获取
  - 方法里面最后一个表达式的值会被作为返回值(也就是return不用写)
  - ==等同于equals  不会有空指针异常抛出

- groovy的高效特性

  - assert语句

    - 自带的assert语句可以在任何地方进行断言操作

  - 可选类型定义(同时支持强类型和弱类型)

    - 也就是一个弱类型的编程语言  def 变量名  变量类型是根据后面的操作推导出来的,和js比较类似

      ```
      def str = '''
      one
      two
      three'''
      ```

  - 集合API更加简洁

  - 闭包



# 简单的groovy语法

- 使用idea随表创建一个工程

- 在idea上部的tools找到groovy console编辑groovy语句

  ```
  class InBox{
      private int a;
      private int b;

      InBox(int a, int b) {
          this.a = a
          this.b = b
      }

      int getA() {
          return a
      }

      void setA(int a) {
          this.a = a
      }
  }
  InBox inBox = new InBox(10,20)
  println inBox.a
  println inBox.b
  ```

- groovy支持弱类型

  ```
  def a = 10
  a = "haha"

  a = 'a'
  println a
  ```

- groovy任何地方都可以断言

  ```
  def a = 10
  a = "haha"

  a = 'a'
  println a

  assert 'a'==a
  ```

- groovy字符串

  ```
  def version = 1.1
  def s1 = 'hahah'
  def s2 = "gradle version:${version}"
  def s3 = """
  中国
  广东
  深圳
  $version
  """
  def s4 = '''
  中国
  广东
  深圳
  '''
  println s1
  println s2
  println s3
  println s4
  ```

- groovy集合

  ```
  //list集合
  def list = ["张三","李四"]
  list << "王五"
  println list.get(2)
  //map集合
  def buildTools = ["ant":2000,"maven":2004]
  //添加一条数据
  buildTools.gradle = 2009
  //获取数据
  println buildTools.gradle
  println buildTools["ant"]
  ```

- 闭包

  ```
  //闭包
  def c1 = {a->
      println a
  }
  def c2 = {
      println "hello"
  }

  def method1(Closure closure){
      closure "params"
  }
  def method2(Closure closure){
      closure()
  }
  method1 c1
  method2 c2
  ```



# groovy的基础知识(重点)

```
apply plugin: 'java'
version '1.0'
repositories {
    mavenCentral()
}

dependencies {
    testCompile group: 'junit', name: 'junit', version: '4.12'
}
```

每个gradle构建脚本都有一个project实例

第一行apply是一个函数  函数接收map对象 plugin:"java"是map赋值

project的属性version等于1.0

后面两个repositories和dependencies都是方法 后面跟上的参数都是闭包


