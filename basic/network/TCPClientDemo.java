package basic.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",10010);

        OutputStream outputStream = socket.getOutputStream();

        byte[] bytes = "777777777777".getBytes(StandardCharsets.UTF_8);
        outputStream.write(bytes);

        socket.shutdownOutput();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line;
        if ((line = bufferedReader.readLine() )!= null){
            System.out.println(line);
        }
        bufferedReader.close();
        outputStream.close();
        socket.close();

    }
}
