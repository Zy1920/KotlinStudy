fun main(args: Array<String>) {
    val str1="abcgkgb"
    val str2="1234532"

    tag1@for (c in str1) {
        tag2@for (d in str2) {
            if(c=='g'&&d=='4'){
                break@tag1
            }
            println("c=$c,d=$d")
        }
    }
}