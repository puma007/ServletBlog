package cn.com.model;

/**
 * Created by tanhaiyuan on 2015/7/3.
 */
public class Comment {
    public int id;//评论id
    public String content;//评论内容
    public String comname;//评论者名字

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }
}
