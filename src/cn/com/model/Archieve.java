package cn.com.model;

import java.util.Date;
import java.util.List;

/**
 * Created by tanhaiyuan on 2015/7/5.
 */
public class Archieve {
    private Date date;//日期  xxXX年xx月
    List<Article> articleList;//文章列表

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
