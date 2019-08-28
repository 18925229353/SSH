package com.szxs.service;

import com.szxs.entity.Users;

public interface UsersService {
    /**
     * 查询用户名和密码
     * @param users
     * @return
     */
    Users queryUsersNameAndPwd(Users users);
    /**
     * 查询用户是否存在
     * @param name
     * @return
     */

    boolean queryUsersByName(String name);
    /**
     * 注册用户
     * @return
     */
    int registerUser(Users users);
}
