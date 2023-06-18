package com.cy.store.service.impl;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

/*用户模块业务层的实现类*/
@Service/*@Service：将当前类的对象交给Spring来管理，使得能够自动创建对象和对象的维护*/
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
//        通过user参数来获取传递了过来的username
        String username=user.getUsername();
//        调用findByUsername（username）判断用户是否被注册过
        User result=userMapper.findByUsername(username);
//        判断结果集是都为null
        if (result != null){
            throw new UsernameDuplicateException("用户名已注册" );
        }
//        密码加密处理：md5算法（现在已被破译）
//        盐值（随机串）+password+盐值（随机串）——ma5加密算法连续加载三次
        String oldPassword1=user.getPassword();
//        获取随机盐值
        String salt=UUID.randomUUID().toString().toUpperCase();
//        补全数据：记录盐值
        user.setSalt(salt);
//        将密码和盐值作为一个整体进行加密处理，提高了原有密码的安全性
        String md5Password = getMD5Password(oldPassword1,salt);
//        将加密后的密码重新补全设置到User对象中
        user.setPassword(md5Password);
//        补全数据：is_delete设置为0
        user.setIsDelete(0);
//        补全数据：4个日志字段
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date =new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);
//        设置默认头像
        user.setAvatar("/images/index/user.jpg");
//        执行注册业务功能的实现（rows==1）
        Integer rows = userMapper.insert(user);
        if (rows != 1){
            throw new InsertException("在用户注册的过程中产生了未知的异常");
        }
    }

    @Override
    public User login(String username, String password) {
        //判断用户名是否存在
        User result=userMapper.findByUsername(username);
        if (result==null){
            throw new UsernameDuplicateException("用户数据不存在");
        }
        //检测用户的密码是否匹配
        //1先获得数据库中的加密之后的密码
        String oldPassword=result.getPassword();
        //2和用户传过来的密码进行比较
        //2.1先获得盐值
        String salt=result.getSalt();
        //将用户的密码按照相同的MD5算法进行加密
        String newMd5Password=getMD5Password(password,salt);
        //3进行密码比较
        if (!newMd5Password.equals(oldPassword)){
            throw new PasswordNotMatchException("用户密码错误");
        }
        //判断is_delete是否为1
        if (result.getIsDelete()==1){
            throw new UsernameDuplicateException("用户数据不存在");
        }
        //调用mapper层的findByUsername来查询用户的数据
        User user =new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());
        //将当前用户数据返回。返回的数据是为了辅助其他页面做数据展示使用的（uid，username，）
        return user;

    }

    //    定义md5算法加密处理
    private String getMD5Password(String password, String salt){
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }
    @Override
    public void logout(HttpSession session) {
        session.removeAttribute("uid");
        session.removeAttribute("username");
        // 使当前session无效
        session.invalidate();
    }
    @Override
    public void changePassword(Integer uid,
                               String username,
                               String oldPassword,
                               String newPassword){
        User result = userMapper.findByUid(uid);
        if (result == null||result.getIsDelete()==1){
            throw new UserNotFoundException("用户数据不存在");
        }
        //原密码和数据库中的密码进行比较
        String oldMd5Password= getMD5Password(oldPassword,result.getSalt());
        if (!result.getPassword().equals(oldMd5Password)){
            throw new PasswordNotMatchException("密码错误");
        }

        //将新的密码设置到数据库中，将新的密码进行加密，然后更新
        String newMd5Password = getMD5Password(newPassword,result.getSalt());
        if( newPassword == oldPassword){
            throw new PasswordNotMatchException("新密码不能和原密码相等");
        }
        Integer rows = userMapper.updatePasswordByUid(uid, newMd5Password,username,new Date());
        if (rows!= 1){
            throw new UsernameDuplicateException("更新数据时产生未知的异常");
        }
    }

    @Override
    public User getByUid(Integer uid) {
        User result=userMapper.findByUid(uid);
        if (result==null||result.getIsDelete()==1){
            throw new UserNotFoundException("用户数据不存在");
        }

        User user = new User();
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());

        return user;
    }

    @Override
    public void changeInfo(Integer uid, String username, User user) {
        User result = userMapper.findByUid(uid);
        if (result==null||result.getIsDelete()==1){
            throw new UserNotFoundException("用户数据不存在");
        }

        user.setUid(uid);
        //user.setUsername(username);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());

        Integer rows= userMapper.updateInfoByUid(user);
        if (rows!=1){
            throw new UpdateException("更新数据时产生异常");
        }

    }

    @Override
    public void changeAvatar(Integer uid, String avatar, String username) {
        //查询当前用户的数据是否存在
       User result= userMapper.findByUid(uid);
       if (result==null||result.getIsDelete()==1){
           throw new UsernameDuplicateException("用户数据不存在");
       }
       Integer rows=userMapper.updateAvatarByUid(uid,avatar,username,new Date());
       if (rows!=1){
           throw new UpdateException("更新用户头像产生了未知异常");
       }
    }

}


