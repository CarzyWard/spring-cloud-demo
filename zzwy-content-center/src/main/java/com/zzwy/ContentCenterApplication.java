package com.zzwy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * server application
 *
 * @author zzwy
 */
@SpringBootApplication
@MapperScan(basePackages = "com.zzwy.dao")
//@EnableDiscoveryClient
public class ContentCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentCenterApplication.class, args);
    }
}
