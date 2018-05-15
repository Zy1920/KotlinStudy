public class NetUtils {
   /* //饿汉式单例设计模式
    //定义一个变量保存NetUitls的实例  用的时候返回
    private static NetUtils mNetUtils=new NetUtils();
    //1.构造方法私有
    private NetUtils(){}
    //2. 还需要将当前对象的引用传递给外部使用
    public static NetUtils getInstance(){
        return mNetUtils;
    }*/

    //懒汉式单例设计模式
    //定义字段复用赋值   用的时候再赋值
    private static NetUtils mNetUtils=null;
    //1.构造方法私有
    private NetUtils(){}
    //2.提供方法返回当前对象的引用
    public static NetUtils getInstance(){
        synchronized (NetUtils.class){//同步代码块，保证线程安全
            //判断是否为空,为空再创建实例对象，不为空直接返回
            if(mNetUtils==null){
                mNetUtils=new NetUtils();
            }
        }
        return mNetUtils;
    }

    public void sendRequest(){
        //发送网络请求
    }
}
