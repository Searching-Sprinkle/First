package com.cy.store.controller;

import com.cy.store.controller.ex.*;
import com.cy.store.service.ex.*;
import com.cy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/*控制层类的基类*/
public class BaseController {
    /*操作成功的状态*/
    public static final int OK= 200;
    /*不成功的状态*/
    //自动将异常对象传递给此方法的参数列表上
    //项目中产生的异常，会被统一拦截到次方法中，这个方法此时就是充当请求处理的方法，方法的返回值直接给到前端
    @ExceptionHandler({ServiceException.class,FileUploadException.class})//用于统一处理抛出异常
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result= new JsonResult<>(e);

        if (e instanceof UsernameDuplicateException) {
            result.setState(4000);
            result.setMessage("用户名已被占用");
        } else if (e instanceof UserNotFoundException) {
            result.setState(4001);
            result.setMessage("用户数据不存在");
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(4002);
            result.setMessage("用户名密码错误");
        } else if (e instanceof AddressCountLimitException) {
            result.setState(4003);
            result.setMessage("收获地址数量超出上限");
        } else if (e instanceof AddressNotFoundException) {
            result.setState(4004);
            result.setMessage("收货地址未找到");
        } else if (e instanceof AccessDeniedException) {
            result.setState(4005);
            result.setMessage("收货地址非法访问");
        } else if (e instanceof ProductNotFoundException) {
            result.setState(4006);
            result.setMessage("产品未找到");
        } else if (e instanceof CartNotFoundException) {
            result.setState(4007);
            result.setMessage("购物车未找到");
        } else if (e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("注册时产生未知异常");
        } else if (e instanceof UpdateException) {
            result.setState(5001);
            result.setMessage("更新数据时产生未知异常");
        } else if (e instanceof DeleteException) {
            result.setState(5002);
            result.setMessage("删除数据时产生未知异常");
        } else if (e instanceof FileEmptyException) {
            result.setState(6000);
            result.setMessage("文件为空");
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
            result.setMessage("文件大小异常");
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
            result.setMessage("文件类型异常");
        } else if (e instanceof FileStateException) {
            result.setState(6003);
            result.setMessage("文件状态异常");
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
            result.setMessage("文件产生未知异常");
        }
        return result;
    }

    /**
     * 获取session对象中的uid
     * @param session session对象
     * @return 当前用户登录的uid
     */
    protected final Integer getuidFromSession(HttpSession session){
      return Integer.valueOf(session.getAttribute("uid")
              .toString());
    }

    /**
     * 获得当前登录用户的username
     * @param session session对象
     * @return 当前登录用户的用户名
     */
    protected final String getUsernameFromSession(
            HttpSession session){
        return session.getAttribute("username").toString();
    }
}
