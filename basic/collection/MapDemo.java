package basic.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class MapDemo {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();

        map.put("1","aa");
        map.put("2","bb");
        map.put("3","ccc");
        map.put("4","ddd");
        System.out.println(map);

        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            String value = map.get(key);
            System.out.println(key + "," + value);
        }


        TreeMap<Student,String> tm = new TreeMap<>();
        Student student1 = new Student("zs",18);
        Student student2 = new Student("zs",18);
        Student student3 = new Student("azs2",21);
        Student student4 = new Student("zs3",52);
        Student student5 = new Student("zs4",24);
        Student student6 = new Student("zs5",14);

        tm.put(student1,"st");
        tm.put(student2,"st1");
        tm.put(student3,"s2");
        tm.put(student4,"s3");
        tm.put(student5,"s4");
        tm.put(student6,"s5");

        tm.forEach((Student stu ,String str)->{
            System.out.println(stu + "---" + str);
        });

    }
}
