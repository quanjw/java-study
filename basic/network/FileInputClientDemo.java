package basic.network;

import java.io.*;
import java.net.Socket;

public class FileInputClientDemo {
    public static void main(String[] args) throws IOException {
        for (int i=0;i<=10000;i++){
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("C:\\Users\\qjw07\\Desktop\\714fa4db7acb0e3cb0df21bcf1a6929.jpg"));

            Socket socket = new Socket("127.0.0.1",10010);
            OutputStream outputStream = socket.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            int b;
            while ((b = bufferedInputStream.read()) != -1){
                bufferedOutputStream.write(b);
            }
            bufferedOutputStream.flush();
            socket.shutdownOutput();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String s;
            while (( s = bufferedReader.readLine() )!= null){
                System.out.println(s);
            }
            outputStream.close();
            bufferedInputStream.close();
            bufferedReader.close();
            bufferedOutputStream.close();
            socket.close();
        }

    }
}
