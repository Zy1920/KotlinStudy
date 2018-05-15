package java接口回调;
public class Mother{
    public static void main(String[]args){
        SuperMarket superMarket=new SuperMarket();
        superMarket.buySoy(new FeedBack() {
            @Override
            public void feed(Soy soy) {
                System.out.println("买到了"+soy.name+"牌酱油");
                System.out.println("妈妈开始做饭了");
            }
        });
        System.out.println("妈妈开始做蛋糕了");
    }
    //第一步:定义能力:取物品的能力
    interface FeedBack {
        void feed(Soy soy);
    }
    static class Son implements FeedBack{
        @Override
        //第四步:在具有能力的对象方法下进行接收
        public void feed(Soy soy) {
            System.out.println("买到了"+soy.name+"牌酱油");
            System.out.println("妈妈开始做饭了");
        }
    }
}















/*


public class Mother {
    public static void main(String[] args) {
        SuperMarket superMarket=new SuperMarket();
        superMarket.buySoy(new FeedBack() {
            @Override
            public void feed(Soy soy) {
                System.out.println("买到了"+soy.name+"牌的酱油");
                System.out.println("妈妈开始做饭了");
            }
        });
        System.out.println("妈妈开始做甜点了");
    }
    interface FeedBack{
        void feed(Soy soy);
    }

    static class Son implements FeedBack{
        @Override
        public void feed(Soy soy) {
            System.out.println("买到了"+soy.name+"牌的酱油");
            System.out.println("妈妈开始做饭了");
        }
    }
}
*/
