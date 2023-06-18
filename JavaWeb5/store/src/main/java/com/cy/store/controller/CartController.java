package com.cy.store.controller;


import com.cy.store.service.ICartService;
import com.cy.store.util.JsonResult;
import com.cy.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("carts")
@RestController
public class CartController extends BaseController{
    @Autowired
    private ICartService cartService;

    @RequestMapping("add_to_cart")
    public JsonResult<Void> addToCart(Integer pid, Integer amount, HttpSession session){
        cartService.addToCart(getuidFromSession(session),pid,amount,getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }

    @RequestMapping({"","/"})
    public JsonResult<List<CartVO>> getVOByUid(HttpSession session){
        List<CartVO> data =cartService.getVOByUid(getuidFromSession(session));
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("{cid}/num/add")
    public JsonResult<Integer> addNum(@PathVariable("cid") Integer cid, HttpSession session) {
            Integer data = cartService.addNum(cid,getuidFromSession(session),getUsernameFromSession(session));
        // 返回成功
        return new JsonResult<>(OK, data);
    }
    @RequestMapping("{cid}/num/reduce")
    public JsonResult<Integer> reduceNum(@PathVariable("cid") Integer cid, HttpSession session) {
        Integer data = cartService.reduceNum(cid,getuidFromSession(session),getUsernameFromSession(session));
        // 返回成功
        return new JsonResult<>(OK, data);
    }

    @RequestMapping("list")
    public JsonResult<List<CartVO>> getVOByCid(Integer[] cids, HttpSession session) {
        // 从Session中获取uid
        Integer uid = getuidFromSession(session);
        // 调用业务对象执行查询数据
        List<CartVO> data = cartService.getVOByCid(uid, cids);
        // 返回成功与数据
        return new JsonResult<>(OK, data);
    }

    @RequestMapping("{cid}/delete")
    public JsonResult<Void> delete(@PathVariable("cid")Integer cid,HttpSession session) {
        cartService.delete(cid,getuidFromSession(session),getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }
}
