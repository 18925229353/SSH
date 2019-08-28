package com.szxs.filter;

import com.szxs.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        request.setCharacterEncoding("utf-8");
        Session session=null;
        Transaction transaction=null;
        try{
            session= HibernateUtil.getSession();
            transaction=session.beginTransaction();
            filterChain.doFilter(servletRequest,servletResponse);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }finally {

           /* session.close();*/
        }
    }

    public void destroy() {

    }
}
