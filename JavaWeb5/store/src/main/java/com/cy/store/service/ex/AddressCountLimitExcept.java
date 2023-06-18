package com.cy.store.service.ex;

/**收货地址总数超出限制的异常*/
public class AddressCountLimitExcept extends ServiceException{
    public AddressCountLimitExcept() {
        super();
    }
    public AddressCountLimitExcept(String message) {
        super(message);
    }

    public AddressCountLimitExcept(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressCountLimitExcept(Throwable cause) {
        super(cause);
    }

    protected AddressCountLimitExcept(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
