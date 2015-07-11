package cn.com.dao;


import javax.swing.text.StyledEditorKit;
import java.sql.Statement;
import java.sql.*;

/**
 * Created by tanhaiyuan on 2015/7/7.
 */
public class BaseDao {
    private String url = "jdbc:mysql://localhost:3306/servletblog";
    private String name = "root";
    private String password = "tanhaiyuan";

    private Connection conn;
    protected PreparedStatement ps;
    protected ResultSet rs;

    /**
     * 获取conn
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url);
    }

    /**
     * 关闭数据库连接
     * @throws SQLException
     */
    public void closeConnection() throws SQLException {
        if(rs != null){
            rs.close();
        }
        if(ps != null){
            ps.close();
        }
        if(conn != null){
            conn.close();
        }
    }

    /**
     * 创建ps
     * @param sql
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public PreparedStatement getPreparedStatement(String sql) throws SQLException, ClassNotFoundException {
        if (ps == null) {
            if (conn == null) {
                createConnection();
            }
        }else{
            ps.close();
        }
        ps = conn.prepareStatement(sql);
        return ps;
    }

    /**
     * 添加对象
     * @param ob
     * @return
     */
    public boolean add(Object ob){
        return true;
    }

    /**
     * 删除对象
     * @param ob
     * @return
     */
    public boolean delete(Object ob){
        return true;
    }

    /**
     * 修改对象
     * @param ob
     * @return
     */
     public boolean modify(Object ob){
        return true;
    }
}
