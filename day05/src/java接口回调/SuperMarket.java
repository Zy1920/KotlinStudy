package java接口回调;
public class SuperMarket {
    //第二步:接收具有能力的接口对象
    public void buySoy(Mother.FeedBack feedBack){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Soy soy=new Soy("海天");
                //第三步:通过接口对象将数据传回去
                feedBack.feed(soy);
            }
        }).start();
    }
}
















/*

public class SuperMarket {
    public void buySoy(Mother.FeedBack feedBack){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Soy soy=new Soy("海天");
                feedBack.feed(soy);
            }
        }).start();
    }
}*/

