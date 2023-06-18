package com.cy.store.mapper;
import com.cy.store.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 此处定义Sql语句的抽象方法
 */
@Repository
@Mapper
/** 处理收货地址数据的持久层接口 */
public interface AddressMapper {
    /**
     * 插入收货地址数据
     * @param address 收货地址数据
     * @return 受影响的行数
     */
    Integer insert(Address address);

    /**
     * 统计某用户的收货地址数据的数量
     * @param uid 用户的id
     * @return 该用户的收货地址数据的数量
     */
    Integer countByUid(Integer uid);

    /**
     * 根据用户id查询用户数据
     * @param uid 用户id
     * @return 用户数据
     */
    List<Address> findByUid(Integer uid);

    /**
     * 根据aid查询收货地址数据
     * @param aid 收货地址id
     * @return 收货地址数据，如为空返回null
     */
    Address findByAid(Integer aid);

    Integer updateNonDefaultByUid(Integer uid);

    Integer updateDefaultByAid(@Param("aid") Integer aid,
                               @Param("modifiedUser") String modifiedUser,
                               @Param("modifiedTime") Date modifiedTime);


    /**
     * 根据收货地址id删除收货地址数据
     * @param aid 收货地址的id
     * @return 受影响的收货地址的行数
     */
     Integer deleteByAid(Integer aid);

    /**
     * 根据用户uid来查询当前用户最后一次被修改的收货地址的数据
     * @param uid 用户id
     * @return 收货地址
     */
    Address findLastModified(Integer uid);

}