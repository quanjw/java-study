package basic.generic;

public class GenericDemo {
    public static void main(String[] args) {
        //Class
        Genertic<String> genertic1 = new Genertic<String>();
        genertic1.setT("generic");
        System.out.println(genertic1.getT());

        Genertic<Integer> genertic2 = new Genertic<Integer>();
        genertic2.setT(1000);
        System.out.println(genertic2.getT());

        //Method
        Genertic2 genertic21 = new Genertic2();
        genertic21.show("Generic Method");
        genertic21.show(222);

        //Interface
        Genertic3 genertic3 = new Genertic3();
        genertic3.show("3333333");

    }
}

class Genertic<T>{
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

class Genertic2{
    public <T> void show(T t){
        System.out.println(t);
    }
}

class Genertic3 implements GenericInterface<String>{
    @Override
    public void show(String s) {
        System.out.println(s);
    }
}
