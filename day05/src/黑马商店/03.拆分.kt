package 黑马商店

fun main(args: Array<String>) {
    println("---黑马商店,过滤用户,过滤条件 购买的商品 未发货 < 已发货---")
    var result1=heimaShop.customers.filter {
        var (hasSend,hasNotSend)=it.orders.partition { it.isDelivered }
        hasSend.size>hasNotSend.size
    }
    println(result1)

    println("---黑马商店,所有订单里面，已发货的，最贵的商品---")
    var result2= heimaShop.customers
            .flatMap{ it.orders}
            .flatMap { it.products }
            .distinct()
            .maxBy { it.price }
    println(result2)
    }