package cn.com.servlet;

import cn.com.dao.ArticleDao;
import cn.com.dao.CategoryDao;
import cn.com.dao.TagDao;
import cn.com.model.Article;
import cn.com.model.Category;
import cn.com.model.Tag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by tanhaiyuan on 2015/7/9.
 */
@WebServlet(name = "ManageListServlet")
public class ManageListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //获取文章
        ArticleDao articleDao = new ArticleDao();
        List<Article> articleList = articleDao.getArticlesByUserId(1);

        //获取分类
        CategoryDao categoryDao = new CategoryDao();
        List<Category> categoryList = categoryDao.getCategorysByUserId(1);
        //获取 标签
        TagDao tagDao = new TagDao();
        List<Tag> tagList = tagDao.getTagsByUserId(1);

        request.setAttribute("articleList", articleList);
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("tagList", tagList);

        request.getRequestDispatcher("managelist.jsp").forward(request, response);
    }
}
