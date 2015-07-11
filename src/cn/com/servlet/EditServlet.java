package cn.com.servlet;

import cn.com.dao.ArticleDao;
import cn.com.dao.CategoryDao;
import cn.com.model.Article;
import cn.com.model.Category;
import cn.com.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

/**
 * Created by tanhaiyuan on 2015/7/3.
 */
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String categoryName = request.getParameter("selectCategory");
        CategoryDao categoryDao = new CategoryDao();
        //int categoryId = categoryDao.getIdbyName(categoryName, 1);
        Category category = categoryDao.getByName(categoryName, 1);
        System.out.println("caterogryid..................."+categoryName);
        System.out.println(category.getId());
        //添加文章
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        System.out.println("title..................."+title);
        System.out.println("content..................."+content);
        ArticleDao articleDao = new ArticleDao();
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setViewcount(0);
        article.setCategory(category);
        //TODO: 添加作者  article.setUser(user);
        User user = new User();
        user.setId(1);
        article.setUser(user);
        //TODO:添加标签   article.setTaglist(tagList)
        Date currentDate = new Date();
        article.setCreatedate(currentDate);
        article.setModifydate(currentDate);
        articleDao.add(article);

        request.setAttribute("article",article);
        request.getRequestDispatcher("detail.jsp").forward(request, response);
    }
}
