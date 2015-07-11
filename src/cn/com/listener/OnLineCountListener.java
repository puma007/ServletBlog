package cn.com.listener; /**
 * Created by tanhaiyuan on 2015/7/8.
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class OnLineCountListener implements HttpSessionListener{

    private int onlineCount;//当前博客在线人数

    /**
     * 将在线人数设置为context属性
     * @param se
     */
    public void setOnLineCountContext(HttpSessionEvent se){
        se.getSession().getServletContext().setAttribute("onlineCount", onlineCount);
    }

    // Public constructor is required by servlet spec
    public OnLineCountListener() {
        onlineCount = 0;
    }

    public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */
        onlineCount++;

    }
    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
        if (onlineCount >= 1) {
            onlineCount--;
        }
    }
}
