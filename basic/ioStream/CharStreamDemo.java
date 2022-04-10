package basic.ioStream;

import java.io.*;

public class CharStreamDemo {
    public static void main(String[] args) throws IOException {
        //C:\Users\qjw07\Downloads\Telegram Desktop\bein sports-193300.txt
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\qjw07\\Downloads\\Telegram Desktop\\bein sports-193300.txt"));

        BufferedWriter bw = new BufferedWriter(new FileWriter("fileMoudle\\bw.txt"));

        String line;
        while ((line=br.readLine())!=null) {
            System.out.println(line);
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        br.close();
        bw.close();


        //OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("myCharStream\\osw.txt"));
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("fileMoudle\\osw.txt"), "GBK");
        osw.write("中国");
        osw.close();

        //InputStreamReader isr = new InputStreamReader(new FileInputStream("myCharStream\\osw.txt"));
        InputStreamReader isr = new InputStreamReader(new FileInputStream("fileMoudle\\osw.txt"), "GBK");
        //一次读取一个字符数据
        int ch;
        while ((ch = isr.read()) != -1) {
            System.out.print((char) ch);
        }
        isr.close();
    }
}
