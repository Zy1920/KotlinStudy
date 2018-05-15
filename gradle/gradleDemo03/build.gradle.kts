task("编译文件"){
    println("开始编译文件啦！~~~")
}

task("opendoor"){
    doFirst{
        println("打开冰箱门")
    }
}
task("closedoor"){
    doFirst{
        println("关闭冰箱门")
    }
}.dependsOn("putelepant")
task("putelepant"){
    doFirst {
        println("放入大象")
    }
}.dependsOn("opendoor")
