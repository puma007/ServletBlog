package cn.com.dao;

import cn.com.model.Article;
import cn.com.model.Category;
import cn.com.model.Comment;
import cn.com.model.Tag;
import cn.com.utils.DateUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanhaiyuan on 2015/7/3.
 */
public class ArticleDao {
    /**
     * 通过用户id 获取文章列表
     *
     * @param userid
     * @return
     */
    public List<Article> getArticlesByUserId(int userid) {
        List<Article> articleList = new ArrayList<Article>();
        Connection conn = DBManager.getConnection();
        String sql = "select id, title, content, createdate, modifydate,viewcount,categoryid from t_article where userid=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userid);
            //执行获取结果集
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Article article = new Article();
                article = new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("content"));
                article.setCreatedate(rs.getDate("createdate"));
                article.setModifydate(rs.getDate("modifydate"));
                article.setViewcount(rs.getInt("viewcount"));

                //获取文章分类
                CategoryDao categoryDao = new CategoryDao();
                int categoryid = rs.getInt("categoryid");
                Category category = categoryDao.getCategoryById(categoryid);

                //获取文章标签
                TagDao tagDao = new TagDao();
                List<Tag> tagList = tagDao.getTagsByArticleId(article.getId());
                article.setTagList(tagList);

                //获取文章评论
                CommentDao commentDao = new CommentDao();
                List<Comment> commentList = commentDao.getComments(article.getId());
                article.setCommentList(commentList);

                articleList.add(article);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(conn);
        }
        return articleList;
    }

    /**
     * 通过文章id 获取文章
     *
     * @param id
     * @return
     */
    public Article getArticleById(int id) {
        Article article = null;
        Connection conn = DBManager.getConnection();
        String sql = "select id, title, content, createdate, modifydate,viewcount from t_article where id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            //执行获取结果集
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                article = new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("content"));
                article.setCreatedate(rs.getDate("createdate"));
                article.setModifydate(rs.getDate("modifydate"));
                article.setViewcount(rs.getInt("viewcount"));

                //获取文章分类
                CategoryDao categoryDao = new CategoryDao();
                Category category = categoryDao.getCategoryByArticleId(article.getId());
                article.setCategory(category);

                //获取文章标签
                TagDao tagDao = new TagDao();
                List<Tag> tagList = tagDao.getTagsByArticleId(article.getId());
                article.setTagList(tagList);

                //获取文章评论
                CommentDao commentDao = new CommentDao();
                List<Comment> commentList = commentDao.getComments(article.getId());
                article.setCommentList(commentList);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(conn);
        }
        return article;
    }

    /**
     * 通过分类id 获取分类下文章数
     *
     * @param categoryid
     * @return
     */
    public int getArticleCountByCategoryId(int categoryid) {
        int count = 0;
        Connection conn = DBManager.getConnection();
        String sql = "select count(*) from t_article where categoryid=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, categoryid);
            //执行获取结果集
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(conn);
        }
        return count;

    }

    /**
     * 通过分类id 获取分类下文章列表
     *
     * @param categoryid
     * @return
     */
    public List<Article> getArticlesByCategoryId(int categoryid) {
        List<Article> articleList = new ArrayList<Article>();
        Connection conn = DBManager.getConnection();
        String sql = "select id, title, content, createdate, modifydate,viewcount,categoryid from t_article where categoryid=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, categoryid);
            //执行获取结果集
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Article article = new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("content"));
                article.setCreatedate(rs.getDate("createdate"));
                article.setModifydate(rs.getDate("modifydate"));
                article.setViewcount(rs.getInt("viewcount"));

                //获取文章分类
                CategoryDao categoryDao = new CategoryDao();
                Category category = categoryDao.getCategoryById(categoryid);

                //获取文章标签
                TagDao tagDao = new TagDao();
                List<Tag> tagList = tagDao.getTagsByArticleId(article.getId());
                article.setTagList(tagList);

                //获取文章评论
                CommentDao commentDao = new CommentDao();
                List<Comment> commentList = commentDao.getComments(article.getId());
                article.setCommentList(commentList);

                articleList.add(article);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(conn);
        }
        return articleList;
    }

    /**
     * 通过标签id 获取标签下文章数
     *
     * @param tagid
     * @return
     */
    public int getArticleCountByTagId(int tagid) {
        int count = 0;
        Connection conn = DBManager.getConnection();
        String sql = "select count(*) from t_article_tag where tagid=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, tagid);
            //执行获取结果集
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(conn);
        }
        return count;
    }

    /**
     * 通过标签id 获取标签下文章列表
     *
     * @param tagid
     * @return
     */
    public List<Article> getArticlesByTagId(int tagid) {
        List<Article> articleList = new ArrayList<Article>();
        Connection conn = DBManager.getConnection();
        String sql = "select articleid from t_article_tag where tagid=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, tagid);
            //执行获取结果集
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                Article article = getArticleById(id);
                articleList.add(article);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(conn);
        }
        return articleList;
    }

    /**
     * 添加文章
     *
     * @param article
     * @return
     */
    public boolean add(Article article) {
        Connection conn = DBManager.getConnection();
        String sql = "insert into t_article(title, content, viewcount, userid, categoryid, createdate, modifydate) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContent());
            ps.setInt(3, article.getViewcount());
            ps.setInt(4, article.getUser().getId());
            ps.setInt(5, article.getCategory().getId());
            ps.setDate(6, DateUtil.UtilToSqlDate(article.getCreatedate()));
            ps.setDate(7, DateUtil.UtilToSqlDate(article.getModifydate()));

            //插入标签
            //TODO: 插入标签

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(conn);
        }
        return true;
    }

    public boolean update(Article article) {
        Connection conn = DBManager.getConnection();
        String sql = "update t_article set title=?, content=?, viewcount=?, categoryid=?, createdate=?, modifydate=? where id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContent());
            ps.setInt(3, article.getViewcount());
            ps.setInt(4, article.getCategory().getId());
            ps.setDate(5, DateUtil.UtilToSqlDate(article.getCreatedate()));
            ps.setDate(6, DateUtil.UtilToSqlDate(article.getModifydate()));
            ps.setInt(7, article.getId());
            //插入标签
            //TODO: 插入标签

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(conn);
        }
        return true;
    }

    public boolean delete(int id) {
        Connection conn = DBManager.getConnection();
        String sql = "delte from t_article where id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            //插入标签
            //TODO: 插入标签
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(conn);
        }
        return true;
    }

    public boolean delCategory(int id){
        List<Article> articleList = getArticlesByCategoryId(id);
        for(int i=0; i<articleList.size(); i++){
            articleList.get(i).setCategory(null);
        }
        return true;
    }

}

