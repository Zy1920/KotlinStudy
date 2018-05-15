### day07  gradle

### gradle简介

- 原始人流程化操作：编译—测试—手动依赖管理—打包—上传服务器；而现代人则使用自动化构建工具进行操作
- java常见的构建工具：
  - **Ant**：2000年，用于编译测试
  - **Maven**：2007年，用于编译测试和依赖管理
  - **Gradle：2012年，用于编译测试、依赖测试和DSL自定义扩展任务**
- gradle是什么：gradle是一种可以用kotlin代码控制的一种智能的自动化构建工具，是一种用代码来控制工具，而不是xml配置来控制工具。总而言之，Gradle是一个很牛逼的构建工具，构建一切可构建的内容。
- **gradle优点：提高工作效率，解放双手。**

### gradle环境配置

- gradle环境配置：gradle中默认使用groovy语言来写的。新建好gradle项目后，修改build.gradle为build.gradle.kts，关闭项目后再重新打开项目，用kotlin语言重写build.gradle.kts中的代码。

- **gradle支持java开发：1.项目中创建src文件夹——main文件夹——java文件夹；2.1完成后仍然无法在java文件夹中写java程序，需要在build.gradle.kts中配置plugins{application}，生成java构建环境。(ctrl+alt+空格提示)；3.程序运行正确后，需要在build.gradle.kts中配置主函数名，在Gradle控制台中，distribution中有distZip任务，点击生成zip包；4.生成的zip包在build下的distributions文件夹中，拉到桌面上，bin目录下的.bat文件可在cmd中运行**

- 动态语言(python、groovy、 javascript…)

  静态语言(kotlin、java)

- **gradle支持kotlin开发：1.项目中创建src文件夹——main文件夹——kotlin文件夹；2.1完成后仍然无法在kotlin文件夹中写kotlin程序，需要在build.gradle.kts中配置kotlin构建环境。(ctrl+alt+空格提示)；其余步骤同java开发环境配置一样。**

```kotlin
plugins{
    application
    kotlin("jvm")
}
application{
    mainClassName="TestKt"//注意Kt中K大写，t小写
}
repositories{
    mavenCentral()
}
dependencies{
    compile(kotlin("stdlib"))
}
```

### project和task

- project和task是Gradle本身领域主要的两个对象，Project为task提供了执行的容器和上下文。
- project就是接口，gradle构建的时候，首先根据build.gradle配置文件创建一个project实例，配置文件中所有的代码都会通过task任务的方式插入到project中，project实例可以在配置文件中通过project隐式调用，即配置文件中任何代码都可以看成是通过project.调用
- task任务，每一个操作都可以定义成一个任务，前面学的application插件里面已经打包好了很多任务，可以直接使用。
- 编写第一个task任务，格式：task(任务名){lambda表达式}，任务编写完成后，可在gradle控制台的task文件夹中执行该任务。

```kotlin
task("编译文件"){
    println("开始编译文件啦！~~~")
}
```

- **task任务依赖格式：.dependsOn()**，()里存放被依赖的任务名。示例如下：

```ko
task("opendoor"){
    println("打开冰箱门")
}
task("closedoor"){
    println("关闭冰箱门")
}.dependsOn("putelepant")
task("putelepant"){
    println("放入大象")
}.dependsOn("opendoor")
```

​	点击closedoor任务，执行结果为：

​	:opendoor UP-TO-DATE
​	:putelepant UP-TO-DATE
​	:closedoor UP-TO-DATE

​	与任务编写的顺序无关。

- task扫描生命周期和运行生命周期
  - 扫描生命周期：gradle配置文件时，gradle会首先找到每一个任务，执行每一个任务中闭包中的逻辑，即无论任务执行与否，闭包中的逻辑都执行了，这称为扫描生命周期
  - 运行生命周期：把任务闭包中的内容放入到doFirst或doLast ,必须先执行了任务才会执行闭包中的内容，称为运行生命周期；doFirst和doLast的区别：同一个任务中的闭包，先执行doFirst，再执行doLast
- tasks任务集代码示例

```kotlin
tasks{
    "opendoor"{
        group="大象放冰箱"//任务组
        doFirst{
            println("打开冰箱门")
        }
    }
    "putelepant"{
        group="大象放冰箱"
        doFirst{
            println("放入大象")
        }
    }.dependsOn("opendoor")
    "closedoor"{
        group="大象放冰箱"
        doFirst {
            println("关闭冰箱门")
        }
    }.dependsOn("putelepant")
}
```

- 默认属性：gradle在未创建构建环境时，也会有一些默认属性,如下代码为打印默认属性的代码实现

```kotlin
task("打印默认属性"){
    group="默认属性"
    doFirst {
        project.properties.forEach { t, any ->
            println("$t----$any")
        }
    }
}
```

- gradle增量更新，指定输入源输出源：inputs.dir()；inputs.file()；outputs.dir()；outputs.file()

```java
task("拷贝工作量"){
    //指定输入源
    inputs.dir("src")
    //指定输出源
    outputs.files("info.txt")
    doFirst{
        //获取src下的文件树
        var dir=fileTree("src")
        //创建接收的文件infofile
        var infofile=File("info.txt")
        dir.forEach{
            if(it.isFile){
                Thread.sleep(1000L)
                //是文件的话将文件名添加到infofile文件中去
                infofile.appendText(it.name)
                infofile.appendText("\n")//换行
            }
        }
    }
}
```



### 插件

- 定义：插件是包含一个或多个任务的合集

- gradle中插件分两类：

  - gradle自带的插件：application、java、war等，调用方式

  ```kotlin
  plugins{
    application
  }
  ```

  - 三方的公司或者个人开发的插件，也可以使用，到gradle官网中的插件市场查找，调用方式分两种：通过plugins{id+版本号}调用(功能可能不是很完善)；或者通过apply调用
  - 调用方式一：

  ```kotlin
  plugins {
      id("com.xenoterracide.gradle.java-lib") version("0.1.21")
  }
  ```

  - 调用方式二：

  ```kotlin
  buildscript {
      repositories {
          maven {
              setUrl("https://plugins.gradle.org/m2/")//setUrl()
          }
      }
      dependencies {
          classpath("gradle.plugin.com.xenoterracide.gradle:pluginbundle:0.1.21")//classpath加()
      }
  }
  apply{
      plugin("com.xenoterracide.gradle.java-lib")//转换成apply+lambda表达式形式
  }
  ```




### 依赖管理

- 依赖管理产生背景：所有软件在最开始时都不会很大,随着时间的推移,软件平台不断膨胀,各个组件或模块之间的依赖变的越来越复杂.如果管理不当就会陷入泥潭
- **gradle中的依赖管理(dependencies)：只需要引入互联网配置(到代码仓库中，如：mavenCentral中找到相应的jar包配置)，再在gradle构建环境中配置即可，一切由gradle自动搞定，无需再关心jar包的依赖。**
- 依赖库的坐标
  - Group(组):用包名来命名,表示由哪一个组织开发  相当于籍贯
  - Name(名):项目名  类似于姓名
  - Version(版本号):定义jar包的版本身份证号
- 代码仓库：repositories，存放代码的地方；常见的代码仓库有：
  - mavenCentral(java开发常用)
  - Jcenter(安卓开发常用)
  - Local本地仓库(mavenCentral, Jcenter)
  - 文件仓库(不建议使用)
  - 自定义maven仓库(最常用 maven私服)

```kotlin
plugins{//调用本地插件
    application
    kotlin("jvm")
}
repositories{//代码仓库
    mavenCentral()//从mavenCentral代码仓库中导入依赖jar包
}
dependencies{//依赖管理
    compile(kotlin("stdlib"))
  	compile(group: "commons-httpclient", name: "commons-httpclient", version: "3.1") //从mavenCentral中导入commons-httpclient的jar包
}
```

- **编译时依赖：compile 测试时依赖：testcompile**




### 依赖冲突及解决方案

- 什么是依赖冲突？

  - 项目需要C和D两个依赖，C需要依赖A(haha.jar) 1.0版本，D需要依赖A(haha.jar)2.0版本，那么调用A里面的sayHello方法，究竟执行的是1.0版本的还是2.0版本的？

- 解决依赖冲突的三种方式：

  - Gradle自动依赖最高版本的依赖，高版本jar包对低版本jar包有兼容性。
  - 关闭gradle默认处理方案，遇到版本冲突的时候提示冲突

  ```kotlin
  configurations.all {
    resolutionStrategy{    
      failOnVersionConflict()
    }
  }
  ```

  ​	排除传递性依赖：在依赖的配置里写上exclude("group","module"),及排除指定group和module的jar包

  - 强制指定一个版本

  ```kotlin
  configurations.all {
    resolutionStrategy{    
      failOnVersionConflict()
      force("commons-logging:commons-logging:1.0.1")
    }
  }
  ```




### gradle扩展任务

- gardle官网——gardle docs——Groovy DSL Reference——task types，可以查看gradle中已经定义好的任务。查看其具体用法，可重新定义其扩展任务。

```kotlin
plugins{
    java
}
task("拷贝文件",Copy::class){//重定义copy任务
    from("src/main/java")
    into("temp")
}
task("删除文件",Delete::class){//重定义delete任务
    delete("temp")
}
```



### 多模块构建

- idea每一个project相当于eclipse工作空间，idea每一个module相当于eclipse的project工程。
- 软件设计原则:高内聚，低耦合——分模块开发
- project下的Core模块的构建配置

```kotlin
plugins{
    application
    kotlin("jvm")
}
repositories{
    mavenCentral()
}
dependencies{
    compile(kotlin("stdlib"))
    testCompile("junit","junit","4.12")//导入junit配置，测试用
}
```

- **App模块依赖于Core模块:compile(project(":Core"))**，其构建配置为：

```kotlin
plugins{
    application
    kotlin("jvm")
}
repositories{
    mavenCentral()
}
dependencies{
    compile(kotlin("stdlib"))
    compile(project(":Core"))//依赖core模块
}
```

- setting.gradle:module的全局配置;

  project下build.gradle:整个工程的构建;

  module下的build.gradle:当前module的gradle构建;

- 子模块中通用的环境配置可以提取到project中构建。

  如下。注意点为：1.插件的调用有两种形式，plugins调用功能可能不是很完善，如报错可换成apply调用方式() 

  2.buildscript是gradle的环境配置，不能放在allprojects里面配置。

```kotlin
buildscript {
    repositories {
        maven {
            setUrl("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.2.41")
    }
}
allprojects{
    apply{
        plugin("org.jetbrains.kotlin.jvm")
    }
}
```



