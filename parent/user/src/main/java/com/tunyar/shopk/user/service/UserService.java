package com.tunyar.shopk.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional
    public void save(){
        jdbcTemplate.update("INSERT INTO `user`(`user_name`) VALUES ('猿氏凯')");
    }
}
