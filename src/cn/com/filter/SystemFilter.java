package cn.com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by tanhaiyuan on 2015/7/7.
 */
@WebFilter(filterName = "SystemFilter")
public class SystemFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String path = ((HttpServletRequest)req).getServletPath();
        if(path.contains("Servlet")){

        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
