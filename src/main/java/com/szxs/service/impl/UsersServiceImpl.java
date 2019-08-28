package com.szxs.service.impl;

import com.szxs.dao.UsersDao;
import com.szxs.dao.impl.UsersDaoImpl;
import com.szxs.entity.Users;
import com.szxs.service.UsersService;

public class UsersServiceImpl implements UsersService {
    UsersDao dao =new UsersDaoImpl();

    public Users queryUsersNameAndPwd(Users users) {

        return dao.queryUsersNameAndPwd(users);
    }

    public boolean queryUsersByName(String name) {


        return dao.queryUsersByName(name)>0;
    }

    public int registerUser(Users users) {
       return dao.registerUser(users);
    }

}
