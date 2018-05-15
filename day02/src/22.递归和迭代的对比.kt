fun main(args: Array<String>) {
    println(sum(100))
}

fun sum(n:Int):Int{
    if(n==1){
        return 1
    }
    else{
        return n+sum(n-1)
    }
}