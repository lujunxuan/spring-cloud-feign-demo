package com.tunyar.shopk.goods.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tunyar.shopk.feign.user.UserFeignService;
import com.tunyar.shopk.goods.service.GoodsService;
import com.tunyar.shopk.goods.utils.SentinelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class GoodsController {
    @Autowired
    UserFeignService userFeignService;
    @Autowired
    GoodsService goodsService;

    @GetMapping("/getgoodsinfo")
    public String test(Integer id){
        //return userName;
        return userFeignService.getUserName(10+id);
        //shopk-goods.properties
    }

    @Value("${name:猿氏凯}")
    String userName;

    @GetMapping("/getsentinel/resource")
    @SentinelResource(value="test",blockHandler = "getSentinelResourceHandle",blockHandlerClass = {SentinelUtil.class})
    public String testSentinel(){
        return "资源限制";
    }

    @GetMapping("/getsentinel/hot")
    @SentinelResource(value="test",blockHandler = "getHotSentinelResourceHandle",blockHandlerClass = SentinelUtil.class)
    public String testSentinelHot(Integer id){
        return "热点资源限制";
    }

    @GetMapping("/getsentinel/hot2")
    @SentinelResource(value="test2",blockHandler = "getHotSentinelResourceHandle2",blockHandlerClass = SentinelUtil.class)
    public String testSentinelHot2(Integer id){
        return "热点资源限制2";
    }

    public String getHotSentinelResourceHandle2(Integer id,BlockException blockException) {
        return "当前热点访问数过多2";
    }

    @GetMapping("/save")
    public String goodsSave () {
        return goodsService.save();
    }

}