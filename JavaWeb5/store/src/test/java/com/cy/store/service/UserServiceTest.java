package com.cy.store.service;


import com.cy.store.StoreApplication;
import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StoreApplication.class)
public class UserServiceTest {
    @Autowired
    private IUserService userService;
    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("user001");
            user.setPassword("123456");
            userService.reg(user);
            System.out.println("111111111111");
        } catch (ServiceException e) {
//            分别打印类的对象、类的名称
            System.out.println(e.getClass().getSimpleName());
//            获取异常的具体描述信息
            System.out.println(e.getMessage());
        }

    }
    @Test
    public void login(){
    User user= userService.login("user001","123456");
        System.out.println(user);
    }

    @Test
    public void changePassword(){
        userService.changePassword(7,"user07","123456","123456");
        System.out.println("ok");
    }
    @Test
    public void getByUid(){
        System.err.println(userService.getByUid(6));

    }
    @Test
    public void changeInfo(){
        User user = new User();
        user.setPhone("12345678889");
        user.setEmail("user05@qq.com");
        user.setGender(0);
        userService.changeInfo(6,"管理员",user);
        System.out.println("OK");
    }
    @Test
    public void changeAvatar(){
        userService.changeAvatar(7,"/upload/test.png","管理员");
    }
}