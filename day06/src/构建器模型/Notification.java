package 构建器模型;

public class Notification {
    private String title;
    private String content;
    private String img;
    private long time;

    public Notification(Builder builder) {
        this.title = builder.title;
        this.content = builder.content;
        this.img = builder.img;
        this.time = builder.time;
    }
    static class Builder {
        String title;
        String content;
        String img;
        long time;

        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder content(String content) {
            this.content = content;
            return this;
        }
        public Builder img(String img) {
            this.img = img;
            return this;
        }
        public Builder time(long time) {
            this.time = time;
            return this;
        }
        public Notification build() {
            return new Notification(this);
        }
    }
}