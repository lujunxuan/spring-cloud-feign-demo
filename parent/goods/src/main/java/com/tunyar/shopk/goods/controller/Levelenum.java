package com.tunyar.shopk.goods.controller;

public enum Levelenum {
    LEVEL_1(1,0.1),
    LEVEL_2(2,0.2),
    LEVEL_3(3,0.3),
    LEVEL_4(4,0.4);


    private Integer level;
    private Double rate;

    Levelenum(Integer level, Double rate) {
        this.level = level;
        this.rate = rate;
    }

    public static Double getRate(Integer level){
        Levelenum[] o =  values();
        for(int a=0;a<o.length;a++){
            if(o[a].level.equals(level)){
                return o[a].rate;
            }
        }
        return null;
    }
}
