package JavaWeb.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_connection {
    public static void main(String[] args) throws SQLException {
        
        
        // 获取数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java", "root", "1234");
        
        // 本机可以用"jdbc:mysql:///java"
        // 获取执行sql的对象
        Statement stmt = conn.createStatement();
        
        
        // 定义sql语句
        String sql = "update Java.account set money = 1500 where id = 1";
        String sql1 = "update Java.account set money = 1500 where id = 2";
        
        
        try {
            //开启事务 手动提交
            conn.setAutoCommit(false);
            
            // 执行sql
            int count = stmt.executeUpdate(sql);
            int count1 = stmt.executeUpdate(sql1);
            // 处理结果
            System.out.println(count);
            System.out.println(count1);
            
            //保证所以sql全部执行成功再提交 否则回滚 保证事务原子性
            conn.commit();
            
        } catch (Exception e) {
            //回滚事务
            conn.rollback();
            
            e.printStackTrace();
        }
        
        // 获取数据库连接
        stmt.close();
        conn.close();
    }
}
