package com.tunyar.shopk.goods.service;

import com.tunyar.shopk.feign.user.UserFeignService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class GoodsService {
    @Resource
    UserFeignService userFeignService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GlobalTransactional
    @Transactional
    public String save(){
        userFeignService.saveUser();
        jdbcTemplate.update("INSERT INTO `goods`(`goods_name`) VALUES ('猿氏凯的商品1')");
        int a = 1/0;
        return "成功";
    }
}
