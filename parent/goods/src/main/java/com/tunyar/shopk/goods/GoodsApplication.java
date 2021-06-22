package com.tunyar.shopk.goods;

import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@ComponentScan(basePackages ={"com.tunyar.shopk"})
@EnableFeignClients(basePackages ={"com.tunyar.shopk.*"})
@SpringBootApplication
public class GoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(new DataSourceProxy(dataSource));
    }
}
