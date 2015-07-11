package cn.com.dao;

import cn.com.model.Tag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tanhaiyuan on 2015/7/3.
 */
public class TagDao {
    /**
     * 通过文章id获取 tags
     *
     * @param articleid
     * @return
     */
    public List<Tag> getTagsByArticleId(int articleid) {
        List<Tag> tagList = new ArrayList<Tag>();
        Connection conn = DBManager.getConnection();
        String sql = "select tagid from t_article_tag where articleid=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, articleid);
            //执行获取结果集
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tag tag = getTagById(rs.getInt("tagid"));
                tagList.add(tag);
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(conn);
        }
        return tagList;
    }

    /**
     * 通过用户id 获取tags
     *
     * @param userid
     * @return
     */
    public List<Tag> getTagsByUserId(int userid) {
        List<Tag> tagList = new ArrayList<Tag>();
        Connection conn = DBManager.getConnection();
        String sql = "select id, name from t_tag where id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userid);
            //执行获取结果集
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tag tag = new Tag();
                tag.setId(rs.getInt("id"));
                tag.setName(rs.getString("name"));
                tagList.add(tag);
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(conn);
        }
        return tagList;
    }

    /**
     * 通过id 获取标签
     *
     * @param id
     * @return
     */
    public Tag getTagById(int id) {
        Tag tag = null;
        Connection conn = DBManager.getConnection();
        String sql = "select name from t_tag where id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                tag = new Tag();
                tag.setId(id);
                tag.setName(rs.getString("name"));
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(conn);
        }
        return tag;
    }

    /**
     * 添加tag
     *
     * @param userid     用户id
     * @param name       标签名
     * @param createdate 创建时间
     * @return
     */
    public boolean add(int userid, String name, Date createdate) {
        Connection conn = DBManager.getConnection();
        String sql = "insert into t_tag(name, userid) values(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, userid);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(conn);
        }
        return true;
    }

    public boolean delete(int id){
        Connection conn = DBManager.getConnection();
        String sql = "delete from t_tag where id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(conn);
        }
        return true;
    }
}
