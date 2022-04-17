package basic.thread;

import java.util.concurrent.locks.ReentrantLock;

public class LockSellTicket implements Runnable {
    private static int tickets = 100;
    private ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            reentrantLock.lock();
            try {
                if (tickets <= 0) {
                    break;
                } else {
                    Thread.sleep(100);
                    tickets--;
                    System.out.println(Thread.currentThread().getName() + "ticket number" + tickets);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }
        }
    }


}
