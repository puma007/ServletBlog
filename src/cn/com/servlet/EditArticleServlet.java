package cn.com.servlet;

import cn.com.dao.ArticleDao;
import cn.com.dao.CategoryDao;
import cn.com.dao.TagDao;
import cn.com.model.Article;
import cn.com.model.Category;
import cn.com.model.Tag;
import cn.com.model.User;
import cn.com.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by tanhaiyuan on 2015/7/3.
 */
public class EditArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        User user = (User) request.getSession().getAttribute("user");

        if (Utils.ObjectIsNull(user)) {
            response.sendRedirect("login.jsp");
        } else {
            String idStr = request.getParameter("id");

            //添加文章
            if (Utils.ObjectIsNull(idStr)) {
                request.setAttribute("method", "add");
            } else {//编辑文章
                int id = Utils.ToInt(idStr);
                ArticleDao articleDao = new ArticleDao();
                Article article = articleDao.getArticleById(id);
                request.setAttribute("article", article);
                request.setAttribute("method", "edit");
            }
            //获取用户所有分类
            CategoryDao categoryDao = new CategoryDao();
            List<Category> categoryList = categoryDao.getCategorysByUserId(user.getId());
            //获取所有标签
            TagDao tagDao = new TagDao();
            List<Tag> tagList = tagDao.getTagsByUserId(user.getId());

            request.setAttribute("categoryList", categoryList);
            request.setAttribute("tagList", tagList);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        }
    }
}
