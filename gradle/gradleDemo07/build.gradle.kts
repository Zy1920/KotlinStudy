plugins{
    java
}
task("拷贝文件",Copy::class){
    from("src/main/java")
    into("temp")
}

task("删除文件",Delete::class){
    delete("temp")
}