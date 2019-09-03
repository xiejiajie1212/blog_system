package com.bit.blog.util;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.bit.blog.exception.SystemException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButil {
    private static final String URL = "jdbc:mysql://localhost:3306/blogdemo";
    private static final String USER = "root";
    private static final String PASSWORD = "1212";
    private static volatile DataSource DATASOURCE;

    public static DataSource getDataSource() {
        if (DATASOURCE == null) {
            synchronized (DButil.class) {
                if (DATASOURCE == null) {
                    DATASOURCE = new MysqlDataSource();
                    ((MysqlDataSource) DATASOURCE).setURL(URL);
                    ((MysqlDataSource) DATASOURCE).setUser(USER);
                    ((MysqlDataSource) DATASOURCE).setPassword(PASSWORD);
                }
            }
        }
        return DATASOURCE;
    }
    public static Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        try {
            if (resultSet!=null) {
                resultSet.close();
            }
            if (preparedStatement!=null) {
                preparedStatement.close();
            } if (connection!=null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //todo 处理数据库异常
        }
    }
}
