package basic.datetime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class DateTime {
    public static void main(String[] args) {
        //Date.Class
        Date d1 = new Date();
        System.out.println(d1);

        long longDate = 16484780321L*1000;
        Date d2 = new Date(longDate);
        System.out.println(d2);

        long currentTime = System.currentTimeMillis();
        Date d3 = new Date();
        d3.setTime(currentTime);
        System.out.println(d3);

        //SimpleDateFormat.Class
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
        String string = simpleDateFormat.format(d3);
        System.out.println(string);

        Date d4 = null;
        String ss = "2021-03-28 22:47:48";
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            d4 = simpleDateFormat1.parse(ss);
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println(d4);


    }
}
