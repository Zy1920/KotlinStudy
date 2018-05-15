package 黑马商店

//商品
data class Product(val name: String, val price: Double)
//订单
data class Order(val products: List<Product>, val isDelivered: Boolean)
//消费者
data class Customer(val name: String, val city: String, val orders: List<Order>)
//商店
data class Shop(val name: String, val customers: List<Customer>)

//模拟Product数据
val dianFanBao = Product("电饭煲", 400.0)
val weiBoLu = Product("微波炉", 300.0)
val dianKaoXiang = Product("电烤箱", 500.0)
val dianCiLu = Product("电磁炉", 456.0)
val dianTaoLu = Product("电陶炉", 238.0)
val dianYaLiGuo = Product("电压力锅", 558.0)
val kongQiZhaGuo = Product("空气炸锅", 888.0)
val douJiangJi = Product("豆浆机", 99.0)
val kaFeiJi = Product("咖啡机", 299.0)
val mianBaoJi = Product("面包机", 49.0)

//模拟Order数据
val order1 = Order(listOf(weiBoLu), true)
val order2 = Order(listOf(dianCiLu, dianTaoLu, dianKaoXiang), true)
val order3 = Order(listOf(kaFeiJi, mianBaoJi), true)
val order4 = Order(listOf(dianFanBao, dianYaLiGuo), true)
val order5 = Order(listOf(dianFanBao, douJiangJi), true)
val order6 = Order(listOf(kongQiZhaGuo), false)
val order7 = Order(listOf(kaFeiJi), false)
val order8 = Order(listOf(mianBaoJi), true)

//模拟Customer数据
val customer1 = Customer("小王", "北京", listOf(order1, order2))
val customer2 = Customer("老王", "上海", listOf(order3))
val customer3 = Customer("老张", "广州", listOf(order4))
val customer4 = Customer("老马", "深圳", listOf(order5, order6))
val customer5 = Customer("老伍", "东莞", listOf(order6, order7, order8))
val customer6 = Customer("老李", "东莞", listOf(order8))

//模拟商店数据
val heimaShop = Shop("黑马商店", listOf(
        customer1,
        customer2,
        customer3,
        customer4,
        customer5,
        customer6
))