package cn.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by tanhaiyuan on 2015/7/2.
 */
public class DBManager {
    public static Connection getConnection(){
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/servletblog?"
                + "user=root&password=tanhaiyuan&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        return conn;
    }

    public static void closeConnection(Connection conn){
        if(conn != null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
