package com.cy.store.mapper;


import com.cy.store.StoreApplication;
import com.cy.store.entity.Address;
import com.cy.store.entity.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StoreApplication.class)
public class DistrictMapperTests {
    @Autowired
    private DistrictMapper districtMapper;


    @Test
    public void findByParent() {
        List<District> list = districtMapper.findByParent("130100");
        for (District d : list) {
            System.err.println(d);
        }
    }

    @Test
    public void findNameByCode() {
        String name = districtMapper.findNameByCode("610000");
        System.out.println(name);
    }
}
