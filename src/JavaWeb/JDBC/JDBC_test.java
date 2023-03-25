package JavaWeb.JDBC;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * 品牌数据的增删改查操作
 */
public class JDBC_test {
    
    /**
     * 查询所有
     * 1. SQL：select * from tb_brand;
     * 2. 参数：不需要
     * 3. 结果：List<Brand>
     */
    
    @Test
    public void testSelectAll() throws Exception {
        //1. 获取Connection
        //3. 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        //4. 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        
        //5. 获取数据库连接 Connection
        Connection conn = dataSource.getConnection();
        
        //2. 定义SQL
        String sql = "select * from Java.account;";
        
        //3. 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        
        //4. 设置参数
        
        //5. 执行SQL
        ResultSet rs = pstmt.executeQuery();
        
        //6. 处理结果 List<Brand> 封装Brand对象，装载List集合
        
        while (rs.next()) {
            System.out.println(rs);
        }
        
        //7. 释放资源
        rs.close();
        pstmt.close();
        conn.close();
        
    }
    
    
    /**
     * 添加
     * 1. SQL：insert into tb_brand(brand_name, company_name, ordered, description, status) values(?,?,?,?,?);
     * 2. 参数：需要，除了id之外的所有参数信息
     * 3. 结果：boolean
     */
    
    @Test
    public void testAdd() throws Exception {
        // 接收页面提交的参数
        int id = 3;
        String name = "香飘飘";
        int money = 1000;
        
        //1. 获取Connection
        //3. 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        //4. 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        
        //5. 获取数据库连接 Connection
        Connection conn = dataSource.getConnection();
        
        //2. 定义SQL
        String sql = "insert into Java.account(id,name, money) values(?,?,?);";
        
        //3. 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        
        //4. 设置参数
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.setInt(3, money);
        
        
        //5. 执行SQL
        int count = pstmt.executeUpdate(); // 影响的行数
        //6. 处理结果
        System.out.println(count > 0);
        
        
        //7. 释放资源
        pstmt.close();
        conn.close();
        
        
    }
    
    
    /**
     * 修改
     * 1. SQL：
     * <p>
     * update tb_brand
     * set brand_name  = ?,
     * company_name= ?,
     * ordered     = ?,
     * description = ?,
     * status      = ?
     * where id = ?
     * <p>
     * <p>
     * <p>
     * 2. 参数：需要，所有数据
     * 3. 结果：boolean
     */
    
    @Test
    public void testUpdate() throws Exception {
        // 接收页面提交的参数
        int id = 3;
        String name = "香飘飘";
        int money = 2000;
        
        
        //1. 获取Connection
        //3. 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        //4. 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        
        //5. 获取数据库连接 Connection
        Connection conn = dataSource.getConnection();
        
        //2. 定义SQL
        String sql = " update Java.account\n" +
                "         set id  = ?,\n" +
                "         name= ?,\n" +
                "         money = ?\n" +
                "     where id = ?";
        
        //3. 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        
        //4. 设置参数
        
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.setInt(3, money);
        pstmt.setInt(4, id);
        
        //5. 执行SQL
        int count = pstmt.executeUpdate(); // 影响的行数
        //6. 处理结果
        System.out.println(count > 0);
        
        
        //7. 释放资源
        pstmt.close();
        conn.close();
        
        
    }
    
    
    /**
     * 删除
     * 1. SQL：
     * <p>
     * delete from tb_brand where id = ?
     * <p>
     * 2. 参数：需要，id
     * 3. 结果：boolean
     */
    
    @Test
    public void testDeleteById() throws Exception {
        // 接收页面提交的参数
        
        int id = 3;
        
        
        //1. 获取Connection
        //3. 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        //4. 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        
        //5. 获取数据库连接 Connection
        Connection conn = dataSource.getConnection();
        
        //2. 定义SQL
        String sql = " delete from Java.account where id = ?";
        
        //3. 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        
        //4. 设置参数
        
        pstmt.setInt(1, id);
        
        //5. 执行SQL
        int count = pstmt.executeUpdate(); // 影响的行数
        //6. 处理结果
        System.out.println(count > 0);
        
        
        //7. 释放资源
        pstmt.close();
        conn.close();
        
        
    }
    
    
}
