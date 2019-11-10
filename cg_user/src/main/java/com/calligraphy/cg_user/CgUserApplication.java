package com.calligraphy.cg_user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.calligraphy"})
@MapperScan("com.calligraphy.domain.dao")
@EnableTransactionManagement
public class CgUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(CgUserApplication.class, args);
    }

}
