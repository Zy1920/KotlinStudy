plugins{
    application
}

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