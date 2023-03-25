package JavaWeb.JDBC;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class Druid {
    public static void main(String[] args) throws Exception {
        
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        
        String sql = "select * from Java.account";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id"));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
