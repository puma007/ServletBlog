package cn.com.dao;

import cn.com.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by tanhaiyuan on 2015/7/3.
 */
public class UserDao {
    //登陆
    public User loginByName(String username, String password) {
        User user = null;
        Connection conn = DBManager.getConnection();
        String sql = "select * from t_user where name=? and password=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            //执行查询
            ResultSet rs = ps.executeQuery();
            System.out.println("自行查询");
            //判断结果集是否有效
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRegidate(rs.getDate("registerDate"));
            }
            // 释放此 ResultSet 对象的数据库和 JDBC 资源
            rs.close();
            // 释放此 PreparedStatement 对象的数据库和 JDBC 资源
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库连接
            DBManager.closeConnection(conn);
        }
        return user;
    }
   //登陆
    public User loginByEmail(String email, String password) {
        User user = null;
        Connection conn = DBManager.getConnection();
        String sql = "select * from t_user where email=? and password=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            //执行查询
            ResultSet rs = ps.executeQuery();
            System.out.println("自行查询");
            //判断结果集是否有效
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setRegidate(rs.getDate("registerDate"));
            }
            // 释放此 ResultSet 对象的数据库和 JDBC 资源
            rs.close();
            // 释放此 PreparedStatement 对象的数据库和 JDBC 资源
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库连接
            DBManager.closeConnection(conn);
        }
        return user;
    }

    //保存用户
    public void saveUser(User user) {
        Connection conn = DBManager.getConnection();
        String sql = "insert into t_user(email, name, password) values(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(conn);
        }
    }

    //判断用户是否存在
    public boolean userIsExist(User user) {
        Connection conn = DBManager.getConnection();
        String sql = "select * from t_user where name=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.print("username");
                return true;
            }

            sql = "select * from t_user where email=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.print("email");
                return true;
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(conn);
        }
        return false;
    }
}
