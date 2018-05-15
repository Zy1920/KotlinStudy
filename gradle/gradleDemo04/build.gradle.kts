tasks{
    "opendoor"{
        group="大象放冰箱"
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

task("打印默认属性"){
    group="默认属性"
    doFirst {
        project.properties.forEach { t, any ->
            println("$t----$any")
        }
    }
}