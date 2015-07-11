package cn.com.ui;

import cn.com.dao.CategoryDao;
import cn.com.dao.TagDao;
import cn.com.model.Category;
import cn.com.model.Tag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.descriptor.TaglibDescriptor;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by tanhaiyuan on 2015/7/4.
 */
@WebServlet(name = "ToEditServlet")
public class ToEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取分类
        CategoryDao categoryDao = new CategoryDao();
        List<Category> categoryList = categoryDao.getCategorysByUserId(1);
        //获取 标签
        TagDao tagDao  = new TagDao();
        List<Tag> tagList = tagDao.getTagsByUserId(1);

        request.setAttribute("categoryList",categoryList);
        request.setAttribute("tagList",tagList);

        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
