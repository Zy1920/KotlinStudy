fun main(args: Array<String>) {
    //ClassName:`02.continue和break`
    // Description:continue和break只能用在for循环里  不能用在foreach里面

    val a="advhggk"
    for (c in a) {
        if(c=='h'){
            continue
        }
        println(c)
    }
}