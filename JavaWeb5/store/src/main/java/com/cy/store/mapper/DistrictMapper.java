package com.cy.store.mapper;

import com.cy.store.entity.District;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface DistrictMapper {
    /**
     * 根据父代号查询区域信息
     * @param parent 父代号
     * @return 某个父代号区域下的区域列表
     */
    List<District> findByParent(String parent);

    String findNameByCode(String code);

}
