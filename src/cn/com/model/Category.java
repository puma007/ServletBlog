package cn.com.model;

/**
 * Created by tanhaiyuan on 2015/7/3.
 */
public class Category {
    private int id;//分类id
    private String name;//分类名
    private int articleCount;//分类下文章数

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }
}
