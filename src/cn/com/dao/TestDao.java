package cn.com.dao;

import cn.com.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by tanhaiyuan on 2015/7/4.
 */
public class TestDao {
     public static void main(String [] args){
        Connection conn = DBManager.getConnection();
        String sql = "select id, name from t_category where userid=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, 1);
            //执行获取结果集
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                System.out.println(rs.getString("name"));
                String str="吃屎";
                System.out.println(str);
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(conn);
        }

    }
}
