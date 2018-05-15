fun main(args: Array<String>) {
    println(fact(10))
}

fun fact(n:Int):Int{
    if(n==1||n==2){
        return 1
    }
    else{
        return fact(n-1)+fact(n-2)
    }
}