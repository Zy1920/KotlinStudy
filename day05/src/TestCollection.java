import java.util.*;

public class TestCollection {
    public static void main(String[] args) {
        //list
        List<Object> list=new ArrayList<>();
        list.add("高圆圆");
        list.add("范冰冰");
        list.add(23);
        list.add("高圆圆");
        for (Object name:list){
            System.out.println(name);
        }
        Set<String> set=new HashSet<>();
        set.add("高圆圆");
        set.add("陈奕迅");
        set.add("范冰冰");
        set.add("谢娜");
        for (String name:set) {
            System.out.println(name);
        }
        //map
        Map<String,String > map=new HashMap<>();
        map.put("张三","唱歌");
        map.put("李四","跑步");
        map.put("haha","哈哈");
    }
}
