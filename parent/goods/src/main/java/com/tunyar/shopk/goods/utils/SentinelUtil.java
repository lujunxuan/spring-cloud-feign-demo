package com.tunyar.shopk.goods.utils;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class SentinelUtil {
    public String getSentinelResourceHandle(BlockException blockException){
        return "当前访问数过多";
    }

    public String getHotSentinelResourceHandle(Integer id,BlockException blockException) {
        return "当前热点访问数过多";
    }
    public String getHotSentinelResourceHandle2(Integer id,BlockException blockException) {
        return "当前热点访问数过多2";
    }
}
