package com.tunyar.shopk.feign.user.fallback;

import com.tunyar.shopk.feign.user.UserFeignService;
import org.springframework.stereotype.Component;

@Component
public class UserFeignServiceFallBack implements UserFeignService {

    public String getUserName(Integer id) {
        return "服务降级";
    }

    public String saveUser() {
        return "服务降级";
    }
}
