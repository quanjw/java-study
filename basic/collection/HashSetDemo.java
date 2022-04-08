package basic.collection;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Student> hs = new HashSet<Student>();

        Student student1 = new Student("zs",18);
        Student student2 = new Student("zs",18);
        Student student3 = new Student("azs2",21);
        Student student4 = new Student("zs3",52);
        Student student5 = new Student("zs4",24);
        Student student6 = new Student("zs5",14);

        hs.add(student1);
        hs.add(student2);
        hs.add(student3);
        hs.add(student4);
        hs.add(student5);
        hs.add(student6);

        for (Student st : hs){
            System.out.println(st);
        }

    }
}
