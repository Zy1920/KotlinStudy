import kotlin.reflect.KProperty
fun main(args: Array<String>) {
    val bigheadson=bigheadson()
    bigheadson.pmoney=1000//调用setValue方法
    println(bigheadson.pmoney)//调用getValue方法
}
class bigheadson{
    var pmoney:Int by mother()
}

class mother{
    var mmoney=0
    var smoney=0
    operator fun getValue(bigheadson: bigheadson, property: KProperty<*>): Int {
        return smoney
    }
    operator fun setValue(bigheadson: bigheadson, property: KProperty<*>, i: Int) {
        smoney+=50
        mmoney+=i-50
        println(mmoney)
    }
}