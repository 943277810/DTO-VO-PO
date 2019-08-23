package com.bosssoft.hr.train.chp2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author ztanker
 * @date 2019-07-25 15:37
 * @Description
 */


@SpringBootApplication

@MapperScan("com.bosssoft.hr.train.chp2.dao")
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);

    }
}
