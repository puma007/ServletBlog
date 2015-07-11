package cn.com.model;

import java.util.Date;

/**
 * Created by tanhaiyuan on 2015/7/3.
 */
public class User {
    private int id;//id
    private String name;//用户名
    private String email;//用户邮箱
    private String password;//用户密码
    private Date regidate;//注册时间
    private String picUrl;//头像路径

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegidate() {
        return regidate;
    }

    public String getPassword() {
        return password;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegidate(Date regidate) {
        this.regidate = regidate;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
