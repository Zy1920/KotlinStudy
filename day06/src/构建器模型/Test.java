package 构建器模型;

public class Test {
    public static void main(String[] args) {
        Notification noti=
                new Notification
                        .Builder()
                        .title("陈奕迅")
                        .content("爱生活爱陈奕迅！~~~")
                        .img("图片")
                        .time(876L)
                        .build();
    }
}
