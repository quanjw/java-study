package basic.thread;

public class SellTicket implements Runnable{
    private static  int tickets = 100;
    private Object object = new Object();
    @Override
    public void run() {
        while (true){

            if (Thread.currentThread().getName().equals("t1")){
                    boolean result = SellTicket.synchronizedMethod();
                    if (result){
                        break;
                    }
            }else {
                synchronized (SellTicket.class){
                    if (tickets <= 0){
                        break;
                    }else {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        tickets --;
                        System.out.println(Thread.currentThread().getName()+"ticket number"+tickets);
                    }
                }
            }


        }
    }

    private static synchronized boolean synchronizedMethod(){
        if (SellTicket.tickets <= 0){
            return  true;
        }else {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SellTicket.tickets --;
            System.out.println(Thread.currentThread().getName()+"ticket number"+tickets);
            return false;
        }
    }
}
