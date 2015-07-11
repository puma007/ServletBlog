package cn.com.dao;

import cn.com.model.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanhaiyuan on 2015/7/3.
 */
public class CommentDao {
    /**
     * 通过文章id 获取文章评论列表
     *
     * @param articleid
     * @return
     */
    public List<Comment> getComments(int articleid) {
        List<Comment> commentList = new ArrayList<Comment>();
        Connection conn = DBManager.getConnection();
        String sql = "select id, content, comname from t_comment where articleid=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, articleid);
            //执行获取结果集
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comment comment = new Comment();
                comment.setId(rs.getInt("id"));
                comment.setComname(rs.getString("comname"));
                comment.setContent(rs.getString("content"));
                commentList.add(comment);
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(conn);
        }
        return commentList;
    }
}
