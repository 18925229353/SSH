package com.szxs.action;


import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.szxs.entity.ResponseResult;
import com.szxs.entity.Users;
import com.szxs.service.UsersService;
import com.szxs.service.impl.UsersServiceImpl;
import javafx.scene.control.Alert;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class UserAction extends ActionSupport {
    private String name;
    private String password;
    private String message;
    private  String repassword;
    private  String telephone;
    private String username;

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private UsersService UsersBiz=new UsersServiceImpl();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String loginUser() {
        Users users = UsersBiz.queryUsersNameAndPwd(new Users(name, password));
        if (users != null) {
            ServletActionContext.getRequest().getSession().setAttribute("users",users);
            return SUCCESS;
        } else {
            this.setMessage("登入失败");
            return LOGIN;
        }
    }
    public String checkNameUser() throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw=response.getWriter();
        ResponseResult responseResult=new ResponseResult(10000,"用户名不存在!");
        if(UsersBiz.queryUsersByName(name)){
            //存在
            responseResult.setCode(10001);
            responseResult.setMsg("用户名已存在!");
        }

        pw.write(JSON.toJSONString(responseResult));
        pw.flush();
        pw.close();
        return null;
    }

    public String registerUser(){
        Users ru=new Users(this.getName(),this.getPassword(),this.getTelephone(),this.getUsername());
        int id = UsersBiz.registerUser(ru);
        if(id>0){
                ServletActionContext.getRequest().getSession().setAttribute("registerUser",ru);
                this.setMessage("注册成功！");
                return SUCCESS;
            }else{
                this.setMessage("注册失败");
                return LOGIN;
        }
}
    @Override
    public void validate() {
   /* if(this.getName()!=null&this.getName().length()==0){

       addFieldError("name","用户名不能为空!");
        }
        if(this.getPassword()!=null&this.getPassword().length()==0){

            addFieldError("name","密码不能为空!");
        }*/

    }
}
