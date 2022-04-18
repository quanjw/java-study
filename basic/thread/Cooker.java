package basic.thread;

import sun.security.krb5.internal.crypto.Des;

public class Cooker implements Runnable{
    private Desk desk;

    public Cooker(Desk desk) {
        this.desk = desk;
    }

    @Override
    public void run() {
        while(true){
            synchronized (desk.getLock()){
                if (desk.getCount() == 0){
                    break;
                }else {
                    if (!desk.isFlag()){
                        System.out.println("cooker produce");
                        desk.setFlag(true);
                        //desk.setCount(desk.getCount()+1);
                        desk.getLock().notifyAll();
                    }else {
                        try {
                            desk.getLock().wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


}
