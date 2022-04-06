package basic.collection;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ComparableDemo {
    public static void main(String[] args) {
        //Comparable
        Student student1 = new Student("zs",18);
        Student student2 = new Student("zs1",21);
        Student student3 = new Student("azs2",21);
        Student student4 = new Student("zs3",52);
        Student student5 = new Student("zs4",24);
        Student student6 = new Student("zs5",14);

        TreeSet<Student> ts = new TreeSet<Student>();
        ts.add(student1);
        ts.add(student2);
        ts.add(student3);
        ts.add(student4);
        ts.add(student5);

        for (Student student : ts){
            System.out.println(student);
        }

        //Comparator
        TreeSet<Teacher> ts2 = new TreeSet<>(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                int result = o1.getAge() - o2.getAge();
                return  result == 0 ? o1.getName().compareTo(o2.getName()):result;
            }
        });

        Teacher tc1 = new Teacher("fg",18);
        Teacher tc2 = new Teacher("fg1",53);
        Teacher tc3 = new Teacher("fg2",12);
        Teacher tc4 = new Teacher("fg0",53);
        Teacher tc5 = new Teacher("fg4",32);
        Teacher tc6 = new Teacher("fg5",64);

        ts2.add(tc1);
        ts2.add(tc2);
        ts2.add(tc3);
        ts2.add(tc4);
        ts2.add(tc5);
        ts2.add(tc6);

        for (Teacher tc:ts2){
            System.out.println(tc);
        }
    }
}
