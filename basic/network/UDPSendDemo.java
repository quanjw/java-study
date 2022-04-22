package basic.network;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UDPSendDemo {
    public static void main(String[] args) throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket();
        DatagramPacket datagramPacket;

        Scanner scanner = new Scanner(System.in);
        while (true){
            String string = scanner.nextLine();
            if (string.equals("q")){
                break;
            }

            byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
            datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("127.0.0.1"),10086);
            datagramSocket.send(datagramPacket);

        }

        datagramSocket.close();
    }
}
