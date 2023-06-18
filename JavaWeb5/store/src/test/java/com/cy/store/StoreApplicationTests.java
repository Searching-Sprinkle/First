package com.cy.store;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest(classes=StoreApplication.class)//最好加上类的地址以防找不到，编译器是傻逼
@MapperScan("com.cy.store.mapper")
class StoreApplicationTests {
    @Autowired//自动装配
    private DataSource dataSource;
    @Test
    void contextLoads() {
    }
    @Test
    void getConnection() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
}
