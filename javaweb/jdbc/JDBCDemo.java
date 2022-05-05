package javaweb.jdbc;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.导入jar包
        //2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //3.获取连接
        Connection con =  DriverManager.getConnection("jdbc:mysql://192.168.123.188:3306/mysql","root","123456");

        //4.获取执行者对象
        Statement stat = con.createStatement();

        //5.执行sql语句，并且接收结果
        String sql = "SELECT * FROM user";
        ResultSet rs = stat.executeQuery(sql);

        //6.处理结果
        while(rs.next()) {
            System.out.println(rs.getString("User") + "\t" + rs.getString("Host"));
        }

        //7.释放资源
        con.close();
        stat.close();
        con.close();
    }
}
