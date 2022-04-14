package basic.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemom implements Callable<String> {
    @Override
    public String call() throws Exception {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() +":"+ i);
            count += i;
        }
        //返回值就表示线程运行完毕之后的结果
        return Thread.currentThread().getName()+count;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CallableDemom callableDemom = new CallableDemom();
        CallableDemom callableDemom2 = new CallableDemom();

        FutureTask<String> ft = new FutureTask<>(callableDemom);
        FutureTask<String> ft2 = new FutureTask<>(callableDemom2);

        Thread thread = new Thread(ft,"t1");
        Thread thread2 = new Thread(ft2,"t2");

        thread.start();
        thread2.start();

        String s = ft.get();
        String s2 = ft2.get();

        System.out.println(s);
        System.out.println(s2);
    }
}
