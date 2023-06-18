package com.cy.store.service;

import com.cy.store.entity.District;

import java.util.List;


//创建接口并定义抽象方法
public interface IDistrictService {

    /**
     * 根据父代号来查询区域信息（省市区）
     * @param parent 父代号
     * @return 父代号下区域列表
     */
    List<District> getByParent(String parent);

    String getNameByCode(String code);


}
