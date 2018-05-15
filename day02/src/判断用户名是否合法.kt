fun main(args: Array<String>) {
    println(parse("hhew2383dW_fkfE@*"))
}

fun parse(name:String):Boolean{
    if(!(name.length>=3&&name.length<=20)){
        return false
    }
    val upChar='A'..'Z'
    val lowChar='a'..'z'
    val intRange='0'..'9'

    var upCount=0
    var lowCount=0
    var intCount=0

    for (c in name) {
        when(c){
            in upChar->{
                upCount++
            }
            in lowChar->{
                lowCount++
            }
            in intRange->{
                intCount++
            }
            '_'->{

            }
            else->{
                return false
            }
        }
    }
    return upCount>=2&&lowCount>=2&&intCount>=3
}