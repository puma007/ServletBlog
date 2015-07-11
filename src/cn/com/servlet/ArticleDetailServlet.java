package cn.com.servlet;

import cn.com.dao.ArticleDao;
import cn.com.model.Article;
import cn.com.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tanhaiyuan on 2015/7/7.
 */
@WebServlet(name = "ArticleDetailServlet")
public class ArticleDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id = Utils.ToInt(request.getParameter("id"));
        ArticleDao articleDao = new ArticleDao();
        Article article = articleDao.getArticleById(id);
        //浏览人数增加1
        int viewcount = article.getViewcount();
        article.setViewcount(viewcount+1);
        //更新数据库
        articleDao.update(article);

        request.setAttribute("article", article);
        request.getRequestDispatcher("articledetail.jsp").forward(request, response);
    }
}
