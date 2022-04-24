package basic.nio;

import java.nio.ByteBuffer;

public class ByteBufferDemo3 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.put("abc".getBytes());

        byteBuffer.flip();

//        for (int i = 0; i < byteBuffer.limit(); i++) {
//            System.out.println((char) byteBuffer.get());
//        }

        //get(byte[] dst) 读多个字节
        byte [] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
        System.out.println(new String(bytes));

        //get(int index)  读指定索引的字节
        System.out.println((char) byteBuffer.get(1));

        //        rewind()    将position设置为0，可以重复读
        byteBuffer.rewind();
        for (int i = 0; i < byteBuffer.limit(); i++) {
            System.out.println((char) byteBuffer.get());
        }

        byteBuffer.clear();
        byteBuffer.put("qq".getBytes());

        System.out.println("-----------------------");
        byteBuffer.rewind();
        byte[] bytes1 = byteBuffer.array();
        System.out.println(new String(bytes1));
    }
}
