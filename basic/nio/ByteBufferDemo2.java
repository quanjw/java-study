package basic.nio;

import java.nio.ByteBuffer;

public class ByteBufferDemo2 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
//        System.out.println(byteBuffer.position());//0
//        System.out.println(byteBuffer.limit());//10
//        System.out.println(byteBuffer.capacity());//10
//        System.out.println(byteBuffer.remaining());//10
//        System.out.println(byteBuffer.hasRemaining());//true

        byteBuffer.put((byte) 97);
        //byteBuffer.put("aaa".getBytes());
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.limit(10);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.position(0);

        byteBuffer.put("012345678".getBytes());
        System.out.println(byteBuffer.remaining());
        System.out.println(byteBuffer.hasRemaining());

        byteBuffer.position(0);
        for (int i = 0; i < 9; i++) {
            System.out.println(i +"="+byteBuffer.get());
        }


    }
}
