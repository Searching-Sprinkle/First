package com.cy.store.service;


import com.cy.store.entity.Address;

import javax.servlet.http.HttpSession;
import java.util.List;

/*收货地址业务层*/
public interface IAddressService {
    void addNewAddress(Integer uid,String username, Address address);

    List<Address> getByUid(Integer uid);

    void setDefault(Integer aid,Integer uid, String modifiedUser);

    void delete(Integer aid, Integer uid, String username);
    Address getByAid(Integer aid,Integer uid);

}
