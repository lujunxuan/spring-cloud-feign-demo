package com.tunyar.shopk.goods.controller;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_HALF_DOWN;

public class DemoController {

    public static void main(String[] args) {

        // 传入类型为商户类型为0 钱是200 uid为100
        Integer uid = 400; //根据商户查出来的父id --邀请商户的ID
        Integer level = 0;
        BigDecimal money = BigDecimal.valueOf(100);
        getMoney(level,money,uid);
    }

    //获取不同层级的钱
    public static Boolean getMoney(Integer level, BigDecimal money, Integer uid){
        System.out.println(1111);
        // 获取当前用户信息,只计算当前用户应该得多少钱

        User user = getUserInfo(uid);
        System.out.println(user);
        //获取当前用户等级
        Integer userLevel = user.getLevel();
        //获取当前用户的费用比例
        BigDecimal userRate = BigDecimal.valueOf(Levelenum.getRate(userLevel));
        //判断当前用户等级和传入等级的差距，如果有差距就计算断层费用
        System.out.println("等级差:"+ (userLevel - level));
        //当前用户获取佣金比例
        System.out.println("佣金比例"+userRate);
        //如果等级差大于1
        int levelResult = userLevel - level;
        if(userLevel - level > 1){
            System.out.println("----------");
            for (int i = 0; i < levelResult - 1; i++){
                level = level+1;
                System.out.println("叠加比例"+Levelenum.getRate(level));
                userRate = userRate.add(BigDecimal.valueOf(Levelenum.getRate(level)));
            }

        }
        //该用户应该获取的费用
        BigDecimal userMoney =   money.multiply(userRate).setScale(2,ROUND_HALF_DOWN);
        System.out.println("当前用户ID："+uid+"，用户等级："
                +userLevel+"，用户拿到的钱+"+userMoney
                +"，用户提成比例："+userRate);

        // 如果类型是平台那就直接结束
        if(user.getLevel() == 4 ){
            System.out.println("-----------");
            return true;
        }else{
            Integer pid = user.getRoleid();
            return getMoney(userLevel,money,pid);
        }


    }

    // 模拟获取用户
    // 100业务员 200经理 300总监 400平台
    public static User getUserInfo(Integer uid){
        User user = new User();
        if(uid == 100){
            user.setUid(100);
            user.setRoleid(200);
            user.setLevel(1);
        }else if(uid == 200){
            user.setUid(200);
            user.setRoleid(300);
            user.setLevel(2);
        }else if(uid == 300){
            user.setUid(300);
            user.setRoleid(400);
            user.setLevel(3);
        }else if(uid == 400){
            user.setUid(400);
            user.setRoleid(400);
            user.setLevel(4);
        }
        return user;
    }
}

class User{
    private Integer level;
    private Integer uid;
    private Integer roleid;

    public User() {
    }

    public User(Integer level, Integer roleid, Integer uid) {
        this.level = level;
        this.uid = uid;
        this.roleid = roleid;
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "User{" +
                "level=" + level +
                ", uid=" + uid +
                ", roleid=" + roleid +
                '}';
    }
}
