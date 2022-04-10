package basic.ioStream;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class FileDemo {
    public static void main(String[] args) {
        File file = new File("fileMoudle\\aaa");
        if (!file.exists()){
            file.mkdirs();
        }

        File newFile = new File(file,"a.txt");
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //统计文件夹
        File downFile = new File("C:\\Users\\qjw07\\Downloads");
        System.out.println(downFile);
        HashMap<String,Integer> hs = new HashMap<>();
        countFile(hs,downFile);
        System.out.println(hs);
    }

    private static void countFile(HashMap<String, Integer> hm, File downFile) {
        File[] files = downFile.listFiles();
        for (File file:files){
            if (file.isFile()){
                String fileName = file.getName();
                //System.out.println(fileName);
                String[] fileNameArr = fileName.split("\\.");
                if (fileNameArr.length == 2){
                    String fileEndName = fileNameArr[1];
                    if (hm.containsKey(fileEndName)){
                        Integer count = hm.get(fileEndName);
                        count++;
                        hm.put(fileEndName,count);
                    }else {
                        hm.put(fileEndName,1);
                    }
                }
            }else {
                countFile(hm,file);
            }
        }
    }
}
