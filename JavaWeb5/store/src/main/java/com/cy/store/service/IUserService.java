package com.cy.store.service;

import com.cy.store.entity.User;

import javax.servlet.http.HttpSession;

/*用户模块业务层接口*/
public interface IUserService {
    /**
     * 用户注册
     * @param user 用户数据
     */
    void reg(User user);

    /**
     * 用户登录功能
     * @param username 用户名
     * @param password 用户密码
     * @return
     */
    User login(String username,String password);

    void logout(HttpSession session);

    void changePassword(Integer uid,
                        String username,
                        String oldPassword,
                        String newPassword);

    /**
     * 根据用户的id查询用户的数据
     * @param uid 用户的id
     * @return 返回用户数据
     */
    User getByUid(Integer uid);

    void changeInfo(Integer uid,String username, User user);

    /**
     * 修改用户头像
     * @param uid 用户uid
     * @param avatar 用户头像
     * @param username 用户名
     */
    void changeAvatar(Integer uid,String avatar,String username);


}
