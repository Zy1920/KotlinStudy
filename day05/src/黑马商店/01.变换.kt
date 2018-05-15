package 黑马商店

fun main(args: Array<String>) {
    println("--------黑马商店,用户来自哪些城市？--------")
    var result1=heimaShop.customers.map {
        it.city
    }.distinct()
    println(result1)

    println("--------黑马商店,小王买过的所有商品？--------")
    var result2=heimaShop.customers.find{
        it.name=="小王" }
            ?.orders//小王所有的订单
            ?.flatMap {
                it.products
            }?.distinct()
    println(result2)
    println("--------黑马商店,所有用户买过的所有商品？--------")
    var result3=heimaShop.customers.flatMap {
        it.orders
    }.flatMap {
        it.products
    }
    println(result3)
}