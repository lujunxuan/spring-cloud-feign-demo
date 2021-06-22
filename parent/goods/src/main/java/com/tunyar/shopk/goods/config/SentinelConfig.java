package com.tunyar.shopk.goods.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class SentinelConfig {
    @PostConstruct
    public void init(){
        WebCallbackManager.setUrlBlockHandler(new SentinelErrorBackHandler());
        WebCallbackManager.setRequestOriginParser(new IpRequestOriginParser());
    }
}
