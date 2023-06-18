package com.cy.store.service.impl;

import com.cy.store.entity.District;
import com.cy.store.mapper.DistrictMapper;
import com.cy.store.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements IDistrictService {

    @Autowired
    private DistrictMapper districtMapper;
    @Override
    public List<District> getByParent(String parent) {
        List<District> list = districtMapper.findByParent(parent);
        //在网络传输时，为了避免无效数据的传递，可以将无效数据设置为null，可以节省流量，也能提升效率
        for (District d : list){
            d.setId(null);
            d.setParent(null);
        }
        return list;
    }


    //一个超过8行代码的方法都要进行测试
    @Override
    public String getNameByCode(String code) {
        return districtMapper.findNameByCode(code);
    }

}
