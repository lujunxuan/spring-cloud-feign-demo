package com.tunyar.shopk.feign.user;

import com.tunyar.shopk.feign.user.fallback.UserFeignServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "shopk-user",fallback = UserFeignServiceFallBack.class)
public interface UserFeignService {

    @GetMapping("/getusername")
    String getUserName(@RequestParam(value = "id") Integer id);


    @GetMapping("/feign/saveuser")
    String saveUser();
}
