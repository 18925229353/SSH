package com.szxs.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor {

    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String name = actionInvocation.getInvocationContext().getName();

        Object users = actionInvocation.getInvocationContext().getSession().get("users");
        //判断会话是否存在 存在继续执行
        if(users!=null || "login".equals(name)||"checkNameUser".equals(name)||"registerUser".equals(name)){
            return actionInvocation.invoke();
        }

        //不存在跳到登入界面
        return "login";
    }
}
