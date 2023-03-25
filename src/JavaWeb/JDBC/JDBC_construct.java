package JavaWeb.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_construct {
    public static void main(String[] args) throws SQLException {
        
        
        // 获取数据库连接
        Connection coon = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java", "root", "1234");
        // 本机可以用"jdbc:mysql:///java"
        // 获取执行sql的对象
        Statement stmt = coon.createStatement();
        // 定义sql语句
        String sql = "update Java.account set money = 1000 where id = 1";
        // 要使用utf8
        // String sql = "create table Java.ReversePolish (id int,name varchar(20) character set utf8 ) ";
        int count = stmt.executeUpdate(sql); // 受影响的行数
        // 执行sql
        System.out.println(count);
        // 获取数据库连接
        stmt.close();
        coon.close();
    }
}
