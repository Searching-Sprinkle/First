package com.cy.store.mapper;

import com.cy.store.entity.Cart;
import com.cy.store.vo.CartVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
@Mapper
public interface CartMapper {
    /**
     * 插入购物车
     * @param cart 购物车数据
     * @return 受影响的行数
     */
    Integer insert(Cart cart);

    /**
     * 更新购物车某件商品的数量
     * @param cid 购物车数据id
     * @param num 更新的数量
     * @param modifiedUser 修改人
     * @param modifiedTime 修改人
     * @return 受影响的行数
     */
    Integer updateNumByCid(Integer cid, Integer num, String modifiedUser, Date modifiedTime);

    /**
     * 根据购物车的uid和pid查询购物车数据
     * @param uid 用户id
     * @param pid 商品id
     * @return 购物车的数据
     */
    Cart findByUidAndPid(Integer uid,Integer pid);
    /**
     * 根据若干个购物车数据id查询详情的列表
     * @param uid 若干个购物车数据id
     * @return 匹配的购物车数据详情的列表
     */
    List<CartVO> findVOByUid(Integer uid);

    Cart findByCid(Integer cid);
    Integer deleteBycid(Integer cid);

    List<CartVO> findVOByCid(Integer[] cids);
}
