package JavaWeb.JDBC;

import JavaWeb.data.pojo.Account;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBC_ResultSet {
    
    //DQL
    @Test
    public void testResultSet() throws Exception {
        
        // 获取数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java", "root", "1234");
        
        // 本机可以用"jdbc:mysql:///java"
        // 获取执行sql的对象
        Statement stmt = conn.createStatement();
        
        
        // 定义sql语句
        String sql = "select * from Java.account";
        
        // 执行sql 游标形式
        ResultSet rs = stmt.executeQuery(sql);
        
        //封装到新建的Account对象中
        List<Account> list = new ArrayList<>();
        
        while (rs.next()) {
            // getXXX函数获取
            // int id = rs.getInt(1);
            int id = rs.getInt("id");
            String name = rs.getString(2);
            Double money = rs.getDouble(3);
            
            Account account = new Account(id, name, money);
            list.add(account);
            
        }
        
        for (Account account: list) {
            System.out.println(account);
        }
        
        //释放游标
        rs.close();
        stmt.close();
        conn.close();
    }
}
