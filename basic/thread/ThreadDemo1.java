package basic.thread;

public class ThreadDemo1 extends Thread{
    @Override
    public void run() {
        for (int i = 0;i<= 100;i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ThreadDemo1 demo1 = new ThreadDemo1();
        ThreadDemo1 demo2 = new ThreadDemo1();

        //demo1.run();
        //demo2.run();

        demo1.start();
        demo2.start();
    }
}
