package com.szxs.dao.impl;

import com.szxs.dao.UsersDao;
import com.szxs.entity.Users;
import com.szxs.utils.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;

public class UsersDaoImpl implements UsersDao {
    public Users queryUsersNameAndPwd(Users users) {
            Session session= HibernateUtil.openSession();
            String hql="from Users where name=:name and passWord=:passWord";
        users=(Users) session.createQuery(hql).setProperties(users).uniqueResult();
        return users ==null ?null:(Users)users;
    }

    public int queryUsersByName(String name) {
        Session session= HibernateUtil.openSession();
        String hql="select count(id) from Users where name=:name ";
        Long num =(Long)session.createQuery(hql).setParameter("name", name).uniqueResult();
        return num.intValue();
    }

    public int registerUser(Users users) {
        Session session= HibernateUtil.getSession();
      Serializable id = session.save(users);
        return id ==null ?0:(Integer) id;
    }
}
