fun main(args: Array<String>) {
    println(sum1(4))
}

tailrec fun sum1(n:Int,result: Int=0):Int{
    if(n==1){
        return result+1
    }
    else{
        return sum1(n-1,result+n)
    }
}