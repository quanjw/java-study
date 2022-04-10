package basic.ioStream;

import java.io.*;

public class ByteStreamDemo {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\qjw07\\Desktop\\qr-firefox-mozillaonline.ed87d53a76ff.png");
        FileOutputStream fos = new FileOutputStream("fileMoudle\\mn.jpg");

        byte[] bys = new byte[1024];
        int len;
        while ((len=fis.read(bys))!=-1) {
            fos.write(bys,0,len);
        }

        //释放资源
        fos.close();
        fis.close();


        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\qjw07\\Desktop\\714fa4db7acb0e3cb0df21bcf1a6929.jpg"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("fileMoudle\\22.jpg"));

        byte[] by2 = new byte[1024];
        int len2;
        while ((len2=bis.read(by2))!=-1) {
            bos.write(by2,0,len2);
        }

        bos.close();
        bis.close();

    }
}
