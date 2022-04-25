package basic.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NIOServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.bind(new InetSocketAddress(10086));
        serverSocketChannel.configureBlocking(false);
        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null){
                socketChannel.configureBlocking(false);
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                int len;
                while ( (len = socketChannel.read(byteBuffer)) > 0){
                    byteBuffer.flip();
                    System.out.println(new String(byteBuffer.array(),0,len));
                    byteBuffer.clear();
                }

                ByteBuffer byteBuffer2 = ByteBuffer.wrap("it's me ".getBytes());
                socketChannel.write(byteBuffer2);
                socketChannel.close();
            }

        }

    }
}
