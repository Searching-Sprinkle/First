package com.cy.store.mapper;


import com.cy.store.StoreApplication;
import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StoreApplication.class)
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void insert() {
        User user = new User();
        user.setUsername("user3");
        user.setPassword("123");
        Integer rows = userMapper.insert(user);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findByUsername() {
        String username = "user2";
        User result = userMapper.findByUsername(username);
        System.out.println(result);
    }
    @Test
    public void updatePasswordByUid() {
        Integer uid = 3;
        String password = "123456";
        String modifiedUser = "超级管理员";
        Date modifiedTime = new Date();
        Integer rows = userMapper.updatePasswordByUid(uid, password, modifiedUser, modifiedTime);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findByUid() {
        Integer uid = 3;
        User result = userMapper.findByUid(uid);
        System.out.println(result);
    }

    @Test
    public void updateInfoByUid(){
        User user = new User();
        user.setUid(6);
        user.setPhone("13011011119");
        user.setEmail("user05@163.com");
        user.setGender(1);
        userMapper.updateInfoByUid(user);
        System.out.println("ok");
    }
    @Test
    public void updateAvatarByUid(){
        userMapper.updateAvatarByUid(07,"/upload/avatar.png","系统管理员",new Date());
    }
}