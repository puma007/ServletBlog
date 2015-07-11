package cn.com.servlet;

import cn.com.dao.ArticleDao;
import cn.com.model.Article;
import cn.com.model.User;
import cn.com.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by tanhaiyuan on 2015/7/7.
 */
@WebServlet(name = "ManageArticlesServlet")
public class ManageArticlesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        User user = (User) request.getSession().getAttribute("user");
        if (Utils.ObjectIsNull(user)) {
            response.sendRedirect("login.jsp");
        } else {
            ArticleDao articleDao = new ArticleDao();
            List<Article> articleList = articleDao.getArticlesByUserId(user.getId());

            request.setAttribute("user", user);
            request.setAttribute("articleList", articleList);
            request.getRequestDispatcher("managearticles.jsp").forward(request, response);
        }
    }
}
