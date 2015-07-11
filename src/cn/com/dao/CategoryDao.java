package cn.com.dao;

import cn.com.model.Article;
import cn.com.model.Category;

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
public class CategoryDao {
    /**
     * 通过id获取 category
     *
     * @param id
     * @return
     */
    public Category getCategoryById(int id) {
        Category category = null;
        Connection conn = DBManager.getConnection();
        String sql = "select id, name from t_category where id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            //执行获取结果集
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));

                //获取类别 文章数
                ArticleDao articleDao = new ArticleDao();
                int articleCount = articleDao.getArticleCountByCategoryId(category.getId());
                category.setArticleCount(articleCount);
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(conn);
        }
        return category;
    }

    /**
     * 通过文章id获取 category
     *
     * @param articleid
     * @return
     */
    public Category getCategoryByArticleId(int articleid) {
        Category category = null;
        Connection conn = DBManager.getConnection();
        String sql = "select id, name from t_category where id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, articleid);
            //执行获取结果集
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                //获取类别 文章数
                ArticleDao articleDao = new ArticleDao();
                int articleCount = articleDao.getArticleCountByCategoryId(category.getId());
                category.setArticleCount(articleCount);
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(conn);
        }
        return category;
    }

    /**
     * 通过用户id 获取category
     *
     * @param userid
     * @return
     */
    public List<Category> getCategorysByUserId(int userid) {
        List<Category> categoryList = new ArrayList<Category>();
        Connection conn = DBManager.getConnection();
        String sql = "select id, name from t_category where userid=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userid);
            //执行获取结果集
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                //获取类别 文章数
                ArticleDao articleDao = new ArticleDao();
                int articleCount = articleDao.getArticleCountByCategoryId(category.getId());
                category.setArticleCount(articleCount);
                categoryList.add(category);
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(conn);
        }
        return categoryList;
    }

    /**
     * 通过分类名来获取分类id
     *
     * @param name
     * @param userid
     * @return
     */
    public int getIdbyName(String name, int userid) {
       int id = -1;
        Connection conn = DBManager.getConnection();
        String sql = "select id from t_category where name=? and userid=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, userid);
            //执行获取结果集
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               id = rs.getInt("id");
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(conn);
        }
        return id;
    }
     /**
     * 通过分类名来获取分类
     *
     * @param name
     * @param userid
     * @return
     */
    public Category getByName(String name, int userid) {
        Category category = null;
        Connection conn = DBManager.getConnection();
        String sql = "select id, name from t_category where name=? and userid=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, userid);
            //执行获取结果集
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                //获取类别 文章数
                ArticleDao articleDao = new ArticleDao();
                int articleCount = articleDao.getArticleCountByCategoryId(category.getId());
                category.setArticleCount(articleCount);
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(conn);
        }
        return category;
    }

    /**
     * 添加分类
     *
     * @param userid     用户id
     * @param name       分类名
     * @param createdate 创建时间
     * @return
     */
    public boolean add(int userid, String name, Date createdate) {
        Connection conn = DBManager.getConnection();
        String sql = "insert into t_category(name, userid) values(?,?)";
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

    /**
     * 通过id删除分类
     * @param id
     * @return
     */
    public boolean delete(int id){
        Connection conn = DBManager.getConnection();
        String sql = "delete from t_category where id=?";
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
