fun main(args: Array<String>) {
    val range=1..100
    /*for (i in range) {
        println(i)
    }*/

    for ((index,i)in range.withIndex()) {
        println("index=$index,i=$i")
    }

   /* range.forEach {
        println(it)
    }*/

    /*range.forEachIndexed { index, i ->
        println("index=$index,i=$i")
    }*/

}