package cn.com.servlet;

import cn.com.dao.UserDao;
import cn.com.filter.SystemFilter;
import cn.com.model.User;
import cn.com.utils.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tanhaiyuan on 2015/7/3.
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //获取用户
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserDao userDao = new UserDao();
        User user = userDao.loginByEmail(email, password);
        if (!Utils.ObjectIsNull(user)) {
            System.out.println("存在用户");
            // 用户非空  将用户对象放入session中
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("managearticles").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
