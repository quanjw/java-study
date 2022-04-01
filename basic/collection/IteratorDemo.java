package basic.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<String> list =  new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        //指向谁,那么此时就删除谁.
        list.removeIf("b"::equals);
        System.out.println(list);

        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String s = it.next();
            if("c".equals(s)){
                //指向谁,那么此时就删除谁.
                it.remove();
            }
        }

        for(String str : list){
            System.out.println(str);
        }


    }
}
