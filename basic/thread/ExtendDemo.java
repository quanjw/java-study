package basic.thread;

public class ExtendDemo extends Thread{
    @Override
    public void run() {
        for (int i = 0;i<= 100;i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ExtendDemo demo1 = new ExtendDemo();
        ExtendDemo demo2 = new ExtendDemo();

        //demo1.run();
        //demo2.run();

        demo1.start();
        demo2.start();


    }
}
