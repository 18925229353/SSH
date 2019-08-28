package com.szxs.dao;

import com.szxs.entity.Users;

public interface UsersDao {
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

    int queryUsersByName(String name);
    /**
     * 注册用户
     * @return
     */
    int registerUser(Users users);

}
