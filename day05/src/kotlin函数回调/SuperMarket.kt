package kotlin函数回调

class SuperMarket {
    //高阶函数
    fun buySoy(block:(Soy)->Unit){
        Thread{
            Thread.sleep(5000L)
            //创建soy对象
            var soy=Soy("海天")
            //返回soy对象
            block(soy)
        }.start()
    }
}