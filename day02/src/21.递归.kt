fun main(args: Array<String>) {
    println(fiob(5))
}

fun fiob(n:Int):Int{
    if(n==1||n==2){
        return 1
    }
    else{
        return fiob(n-1)+fiob(n-2)
    }
}