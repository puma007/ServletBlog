package cn.com.servlet;

import cn.com.dao.ArticleDao;
import cn.com.dao.CategoryDao;
import cn.com.model.Article;
import cn.com.model.Category;
import cn.com.model.User;
import cn.com.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by tanhaiyuan on 2015/7/13.
 */
public class SaveArticleServlet extends HttpServlet {
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Article article = null;
        CategoryDao categoryDao = new CategoryDao();
        ArticleDao articleDao = new ArticleDao();

        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String categoryName = request.getParameter("selectCategory");
        User user = (User) request.getSession().getAttribute("user");

        //获取分类对象
        Category category = categoryDao.getByName(categoryName, user.getId());
        if(Utils.ObjectIsNull(category)){
            category = new Category();
            category.setId(0);
        }

        if (Utils.ObjectIsNull(id)) {
            //添加文章
            article = new Article();

            article.setUser(user);
            article.setTitle(title);
            article.setContent(content);
            article.setCategory(category);
            article.setViewcount(0);

            Date currentDate = new Date();

            article.setCreatedate(currentDate);
            article.setModifydate(currentDate);

            articleDao.add(article);
        } else {
            //通过id获取文章 更新文章
            article = articleDao.getArticleById(Utils.ToInt(id));
            article.setTitle(title);
            article.setContent(content);
            article.setCategory(category);
            System.out.println("title: " + article.getTitle());
            System.out.println("content: " + article.getContent());

            articleDao.update(article);
        }

        //TODO:添加标签   article.setTaglist(tagList)

        request.setAttribute("article", article);
        request.getRequestDispatcher("articledetail.jsp").forward(request, response);
    }
}
