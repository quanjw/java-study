package basic.network;

import java.io.*;
import java.net.Socket;

public class ThreadSocket implements Runnable{
    private Socket socket;

    public ThreadSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedInputStream bufferedInputStream= null;
        BufferedOutputStream bufferedOutputStream = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedInputStream = new BufferedInputStream(socket.getInputStream());
            final long l = System.currentTimeMillis();
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("fileMoudle\\"+l+".jpg"));

            int b;
            while ((b = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(b);
            }

            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("ok");
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                bufferedOutputStream.close();
                bufferedInputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
