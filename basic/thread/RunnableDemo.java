package basic.thread;

public class RunnableDemo implements Runnable{
    @Override
    public void run() {
        for (int i = 0;i<= 100;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }

    public static void main(String[] args) {
        RunnableDemo demo = new RunnableDemo();

        Thread thread1 = new Thread(demo,"run");
        Thread thread2 = new Thread(demo,"fly");

        //demo1.run();
        //demo2.run();

        thread1.start();
        thread2.start();
    }
}
