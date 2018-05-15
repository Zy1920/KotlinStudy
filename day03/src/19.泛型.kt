fun main(args: Array<String>) {
    val box = Box1<String>("张三")
    println(box.thing)
    val friutbox=FriutBox(Apple())
    println(friutbox.thing)
}
/**
 * ClassName:`19.泛型`
 * 定义对象的时候使用泛型
 * 定义子类时候执行泛型
 * 定义子类的时候不知道具体类型,继续使用泛型
 */

open class Box1<T>(var thing:T)//物品类型不确定，定义泛型和使用泛型
//水果箱子
class FriutBox(thing: Friut):Box1<Friut>(thing)//水果箱子重写箱子
//不知道具体放什么东西的箱子
class sonBox<T>(thing: T):Box1<T>(thing)//
abstract class Friut
class Apple:Friut()
class Orange:Friut()
