package cn.com.servlet;

import cn.com.dao.CategoryDao;
import cn.com.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tanhaiyuan on 2015/7/9.
 */
@WebServlet(name = "ManageCategoryServlet")
public class ManageCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        int id = Utils.ToInt(request.getParameter("id"));
        if(method.equals("modify")){

        }else if(method.equals("del")){
            CategoryDao categoryDao = new CategoryDao();
            categoryDao.delete(id);
        }
    }
}
