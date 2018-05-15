import javax.swing.Box

fun main(args: Array<String>) {
    val box = Box2<String>("张三")
    println(box.thing)
    val friutbox=FriutBox2(Apple())
    println(friutbox.thing)
}
/**
 * ClassName:`19.泛型`
 * 定义对象的时候使用泛型
 * 定义子类时候执行泛型
 * 定义子类的时候不知道具体类型,继续使用泛型
 */

open class Box2<T>(var thing:T)//物品类型不确定，定义泛型和使用泛型
class FriutBox2<T:Friut>(thing: T):Box2<T>(thing)


//不知道具体放什么东西的箱子
class sonBox2<T>(thing: T):Box2<T>(thing)//

open class thing
open class Friut1:thing()
class Apple1:Friut()
class Orange1:Friut()
