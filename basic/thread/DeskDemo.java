package basic.thread;

public class DeskDemo {
    public static void main(String[] args) {
        Desk desk = new Desk();
        Foodie foodie = new Foodie(desk);
        Cooker cooker = new Cooker(desk);
        Thread t1 = new Thread(foodie,"foodie");
        Thread t2 = new Thread(cooker,"cooker");

        t1.start();
        t2.start();

    }
}
