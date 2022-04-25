package basic.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClientDemo {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();

        socketChannel.connect(new InetSocketAddress("127.0.0.1",10086));

        ByteBuffer byteBuffer = ByteBuffer.wrap("is anyone in here".getBytes());
        socketChannel.write(byteBuffer);

        ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);

        int len;
        while ( (len = socketChannel.read(byteBuffer2)) != -1){
            byteBuffer2.flip();
            System.out.println(new String(byteBuffer2.array(),0,len));
            byteBuffer2.clear();
        }

        socketChannel.close();
    }

}
