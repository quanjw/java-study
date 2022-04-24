package basic.nio;

import java.nio.ByteBuffer;

public class ByteBufferDemo {
    public static void main(String[] args) {
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(5);
        for (int i = 0; i < 5; i++) {
            System.out.println(byteBuffer1.get());
        }

        byte[] bytes = {47,23,56,23};
        ByteBuffer byteBuffer2 = ByteBuffer.wrap(bytes);
        for (int i = 0; i < 4; i++) {
            System.out.println(byteBuffer2.get());
        }

        ByteBuffer byteBuffer3 = ByteBuffer.wrap("asdf34da".getBytes());
        for (int i = 0; i < 4; i++) {
            System.out.println(byteBuffer3.get());
        }


    }
}
