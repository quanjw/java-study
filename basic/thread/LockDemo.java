package basic.thread;

public class LockDemo {
    public static void main(String[] args) {
        SellTicket sellTicket = new SellTicket();

        Thread thread1 = new Thread(sellTicket,"t1");
        Thread thread2 = new Thread(sellTicket,"t2");
        Thread thread3 = new Thread(sellTicket,"t3");
        Thread thread4 = new Thread(sellTicket,"t4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
