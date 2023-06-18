package com.cy.store.service;

import com.cy.store.vo.CartVO;

import java.util.List;

public interface ICartService {
    /**
     * 将商品添加到购物车中
     * @param uid 用户id
     * @param pid 商品id
     * @param amount 商品数量
     * @param username 用户名（修改者）
     * @return
     */
    void addToCart(Integer uid,Integer pid,Integer amount,String username);
    List<CartVO> getVOByUid(Integer uid);
    Integer addNum(Integer cid,Integer uid,String username);
    Integer reduceNum(Integer cid, Integer uid, String username);
    void delete(Integer cid, Integer uid, String username);

    List<CartVO> getVOByCid(Integer uid, Integer[] cids);
}
