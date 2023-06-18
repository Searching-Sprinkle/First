package com.cy.store.service.impl;

import com.cy.store.entity.Address;
import com.cy.store.entity.Cart;
import com.cy.store.entity.Product;
import com.cy.store.mapper.CartMapper;
import com.cy.store.mapper.ProductMapper;
import com.cy.store.service.ICartService;
import com.cy.store.service.ex.*;
import com.cy.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;


@Service
public class CartServiceImpl implements ICartService {

    /*购物车的业务层依赖于购物车的持久层以及商品的持久层*/
    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ProductMapper productMapper;
    @Override
    public void addToCart(Integer uid, Integer pid, Integer amount, String username) {
        Cart result = cartMapper.findByUidAndPid(uid,pid);
        Date date = new Date();
        if(result == null){//表示这个商品从来没有被添加到购物车中
            Cart cart = new Cart();
            cart.setUid(uid);
            cart.setPid(pid);
            cart.setNum(amount);
            Product product = productMapper.findById(pid);
            cart.setPrice(product.getPrice());
            cart.setCreatedUser(username);
            cart.setCreatedTime(date);
            cart.setModifiedTime(date);
            cart.setModifiedUser(username);
            Integer rows = cartMapper.insert(cart);
            if(rows != 1){
                throw new InsertException("插入时产生未知的异常");
            }
        }else{//表示当前的商品在购物车中已经存在，则更新这条数据的num值
            Integer num = result.getNum()+amount;
            Integer rows = cartMapper.updateNumByCid(result.getCid(),num,username,date);
            if(rows !=1){
                throw new UpdateException("更新时数据产生未知异常");
            }
        }
    }

    @Override
    public List<CartVO> getVOByUid(Integer uid) {
        return cartMapper.findVOByUid(uid);
    }

    @Override
    public Integer addNum(Integer cid, Integer uid, String username) {
        Cart result = cartMapper.findByCid(cid);
        if(result == null){
            throw new CartNotFoundException("数据不存在");
        }
        if (!result.getUid().equals(uid)){
            throw new AccessDeniedException("数据非法访问");
        }
        Integer num = result.getNum() + 1;
        Integer rows = cartMapper.updateNumByCid(cid,num,username,new Date());
        if(rows !=1){
            throw new InsertException("更新时产生异常");
        }
        return num;
    }

    @Override
    public Integer reduceNum(Integer cid, Integer uid, String username) {
        Cart result = cartMapper.findByCid(cid);
        if(result == null){
            throw new CartNotFoundException("数据不存在");
        }
        if (!result.getUid().equals(uid)){
            throw new AccessDeniedException("数据非法访问");
        }
        Integer num = result.getNum() - 1;
        Integer rows = cartMapper.updateNumByCid(cid,num,username,new Date());
        if(rows !=1){
            throw new InsertException("更新时产生异常");
        }
        return num;
    }

    @Override
    public void delete(Integer cid, Integer uid, String username) {
        Cart result = cartMapper.findByCid(cid);
        if(result == null){
            throw new AddressNotFoundException("商品不存在");
        }
        if (!result.getUid().equals(uid)){
            throw new AccessDeniedException("非法数据访问");
        }
        Integer rows = cartMapper.deleteBycid(cid);
        if(rows !=1){
            throw new DeleteException("删除数据产生未知的异常");
        }

    }

    @Override
    public List<CartVO> getVOByCid(Integer uid, Integer[] cids) {
        List<CartVO> list = cartMapper.findVOByCid(cids);
        Iterator<CartVO> it = list.iterator();
        while (it.hasNext()) {
            CartVO cartVO = it.next();
            if (!cartVO.getUid().equals(uid)) {
                list.remove(cartVO);
            }
        }
        return list;
    }


}
