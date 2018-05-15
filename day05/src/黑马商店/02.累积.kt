package 黑马商店

fun main(args: Array<String>) {
    println("--------黑马商店,小王买东西花了多少钱？--------")
    var result1= heimaShop.customers.find {
        it.name=="小王"
    }?.orders?.filter {
        it.isDelivered
    }?.flatMap {
        it.products
    }?.sumByDouble {
        it.price
    }
    println(result1)
}
