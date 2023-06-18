package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.Date;

/**用户模块的持久层借口**/
@Repository
@Mapper
public interface UserMapper {
    /**
     * 插入用户的数据
     * @param user 用户的数据
     * @return 受影响的行数（增删改时会有受影响的行数作为返回值）
     */
    Integer insert(User user);
/**
 * 根据用户名来查询用户的数据
 * @param username 用户名
 * @return 找到对应用户则返回用户名，否则返回null
 */
    User findByUsername(String username);

    /**
     * 根据用户的uid来修改密码
     * @param uid 用户的id
     * @param password 用户输入的新密码
     * @param modifiedUser 修改的执行者
     * @param modifiedTime 修改数据的时间
     * @return 返回受影响的行数
     */
    Integer updatePasswordByUid(Integer uid, String password, String modifiedUser, Date modifiedTime);

    /**
     * 根据用户的id来查询用户的数据
     * @param uid 用户的id
     * @return 找到就返回对象，反之返回null
     */
    User findByUid(Integer uid);

    /**
     * 更新用户数据
     * @param user 用户数据
     * @return 返回受影响的行数
     */
    Integer updateInfoByUid(User user);

    /**
     * 根据用户uid值来修改用户头像
     * @Param("SQL映射文件中#{}占位符的变量名")：解决的问题，当SQL语句占位符和
     * 映射的接口方法参数名不一致时，需要将某个参数强行注入到某个个占位符变量上时，
     * 可以使用@Param这个注解来标注映射关系
     * @param uid 用户uid
     * @param avatar 用户头像
     * @param modifiedUser 修改人
     * @param modifiedTime 修改时间
     * @return
     */
    Integer updateAvatarByUid(@Param("uid") Integer uid,
                              @Param("avatar") String avatar,
                              @Param("modifiedUser") String modifiedUser,
                              @Param("modifiedTime") Date modifiedTime);
}
