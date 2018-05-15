fun main(args: Array<String>) {
    val a="avbdfsx"

    /*for (c in a) {
        println(c)
    }*/
    for ((index,c )in a.withIndex()) {
        println("index=$index,c=$c")
    }

    /*for ((index,c) in a.withIndex()) {
        println("index=$index,c=$c")
    }*/

    a.forEach {
        println(it)
    }

    a.forEachIndexed { index, c ->
        println("index=$index,c=$c")
    }
}