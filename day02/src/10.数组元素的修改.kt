fun main(args: Array<String>) {
    var arr1= arrayOf(2,4,2,4,56)
    arr1[2]=5
    for (i in arr1) {
        println(i)
    }
    arr1.set(4,57)
    for (i in arr1) {
        println(i)
    }

}