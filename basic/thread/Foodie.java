package basic.thread;

import sun.security.krb5.internal.crypto.Des;

public class Foodie implements Runnable{
    private Desk desk;

    public Foodie(Desk desk) {
        this.desk = desk;
    }

    @Override
    public void run() {
        while (true){
            synchronized (desk.getLock()){
                if (desk.getCount() == 0){
                    break;
                }else {
                    if (desk.isFlag()){
                        System.out.println("eat food");
                        desk.setFlag(false);
                        desk.getLock().notifyAll();
                        desk.setCount(desk.getCount()-1);
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
