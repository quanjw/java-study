package basic.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket  serverSocket = new ServerSocket(10010);

        while (true){
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();

            int length;
            byte[] bytes = new byte[1024];
            if ((length = inputStream.read(bytes)) != -1){
                String data= new String(bytes,0,length);
                System.out.println(data);
            }

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("back");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();

            inputStream.close();
            socket.close();
        }


    }
}
