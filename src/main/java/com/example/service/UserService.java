package com.example.service;

import com.example.entity.User;
import com.example.exception.BizException;
import com.example.mapper.UserMapper;
import com.example.utiles.RedisUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.management.StringValueExp;

import cn.hutool.core.date.DateUnit;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    /**
     * 查询
     *
     * @param id
     * @return
     */
    public User Sel(int id) {
        Object o = redisUtil.get(String.valueOf(id));
        if (o == null) {
            return userMapper.Sel(id);
        } else {
            return (User) o;
        }
    }

    /**
     * 保存
     * @param user
     */
    // @Transactional(rollbackFor = Exception.class, readOnly = false)
    // public void saveUser(User user){
    //     boolean b = false;
    //     userMapper.insert(user);
    //     if(user.getId() % 2 ==0){
    //         log.debug("redis持久化保存");
    //         b = redisUtil.set(user.getId().toString(), user);
    //     }else{
    //         log.debug("redis保存60秒");
    //         b = redisUtil.set(user.getId().toString(), user,60L);
    //     }
    //
    //     log.debug("---用户保存成功---{}",b);
    //
    //     log.debug("===================stringRedisTemplate=========================");
    //     stringRedisTemplate.opsForValue().set("test", "100",60*10, TimeUnit.SECONDS);
    //
    //
    //
    //     log.debug("===================stringRedisTemplate=========================");
    // }

    /**
     * 保存
     *
     * @param user
     */
    @Transactional(rollbackFor = Exception.class, readOnly = false)
    public void saveUser(User user) {

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        Long all = stringRedisTemplate.opsForList().leftPushAll("list", list);//批量追加数据
        Long aLong = stringRedisTemplate.opsForList().leftPush("list", "kkkk");//单个
        Long aLong1 = stringRedisTemplate.opsForList().rightPush("list", "xxxxx");

        System.out.println(all);
        System.out.println(aLong);


        String key = "lockKey";
        try {
            Boolean aBoolean = stringRedisTemplate.opsForValue().setIfAbsent(key, "zhl");//jedis.setnx(key,value);
            if (!aBoolean) {
                return;
            }
            synchronized (this) {
                int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));//jedis.get()
                if (stock > 0) {
                    int realStock = stock - 1;
                    stringRedisTemplate.opsForValue().set("stock", String.valueOf(realStock));
                    System.err.println("扣减库存成功，剩余库存：" + realStock);
                } else {
                    System.err.println("库存不足");
                }
            }
        } catch (Exception e) {
            System.out.println("异常");

        } finally {
            stringRedisTemplate.delete(key);
        }
    }

    /**
     * incr 生成订单号
     */
    public void incr() {

        String date = "20210526";
        int random = (int) (Math.random() * 1000) + 1;//0--1000随机数
        Long incr01 = stringRedisTemplate.opsForValue().increment(date, 2L);
        System.out.println("订单号：" + date + " - " + random + " - " + incr01);
    }

    /**
     * incr ip请求限制器
     */
    public void incrIp() throws Exception {

        String ip = "169.123.45.12";
        Long incr01 = stringRedisTemplate.opsForValue().increment(ip, 1L);
        Boolean expire = stringRedisTemplate.expire(ip, 10, TimeUnit.SECONDS);
        System.out.println("设置过期时间是否成功：" + expire);

        System.out.println("ip当前请求次数：" + incr01);
        if (incr01 >= 10) {
            throw new BizException("请勿重复请求，点击");
        }else{
            System.out.println("正常逻辑");
        }
    }


    public void redisList(){

        List<String> list = new ArrayList<>();
        list.add("16");
        list.add("15");
        list.add("14");
        list.add("13");
        list.add("12");

        Long a = stringRedisTemplate.opsForList().leftPush("rlist", "ip01");
        Long b = stringRedisTemplate.opsForList().leftPush("rlist", "ip02");
        System.out.println(a+"-"+b);
        Long all = stringRedisTemplate.opsForList().leftPushAll("rlist", list);
        System.out.println(all);

        long listLength = stringRedisTemplate.opsForList().size("rlist");//list 长度
        List<String> rlist = stringRedisTemplate.opsForList().range("rlist", 0, listLength);//获取当前key的范围下的集合数据
        for (String s : rlist) {
            System.out.println(s);
        }

    }


    public void removeListOneValue(){


        Long list = stringRedisTemplate.opsForList().remove("list", 1, "1");
        System.out.println(list);

    }



    public void hash(){

        HashMap<String, String> map = new HashMap<>();
        map.put("姓名","zhangssss");
        map.put("年龄","19");
        map.put("性别","男");
        map.put("客户id","1000009797");
        map.put("照片","http：//www.abc.com/a.jpg");

        map.get("");
        //添加一个hashmap
        stringRedisTemplate.opsForHash().putAll("hash",map);

        //查询hash的所有value值
        List<Object> hash = stringRedisTemplate.opsForHash().values("hash");
        Map<Object,Object> m = new HashMap<>();
        for (Object o : hash) {
            String value = String.valueOf(o);
            System.out.println(value);

        }

        //查询hash 键值对，返回map
        m = stringRedisTemplate.opsForHash().entries("hash");
        for(Object key:m.keySet()){
            System.out.println("key:"+key+" "+"Value:"+map.get(key));
        }


    }



    /**
     * 查询全部
     *
     * @return
     */
    public List<User> queryAllUser() {
        List<User> list;
        list = userMapper.findAllUser();
        return list;
    }

    public static void main(String[] args) {

        HashMap<String, String> hashMap = new HashMap<>(56);
        hashMap.put("1", "1");
        hashMap.put("1", "1");
        hashMap.put("1", "1");
        hashMap.put("1", "1");


        System.out.println(new UserService().count("sdfasdfaafa"));
        new ConcurrentHashMap<>();
        // Object a = 1;
        // synchronized (a){
        //
        // }
        //
        // List<? extends Number> ll =new ArrayList<Integer>();
        // // int a =1000;
        // //
        // // AtomicInteger atomicInteger = new AtomicInteger();
        // // int i = atomicInteger.addAndGet(a);
        // // System.out.println(i);
        // //
        // // boolean b = atomicInteger.compareAndSet(a, 10);
        // // System.out.println(b);
        // //
        // // int increment = atomicInteger.getAndIncrement();
        // // System.out.println(increment);
        //
        // User user = new User();
        // Class aClass = user.getClass();
        // User user1 = new User();
        // Class aClass1 = user1.getClass();
        // System.out.println(aClass1 == aClass);
        //
        //
        // Class aClass2 = User.class;
        // System.out.println(aClass2 == aClass);
        //
        // try {
        //     Class aClass3 = Class.forName("com.example.entity.User");
        //     System.out.println(aClass3 == aClass);
        // } catch (ClassNotFoundException e) {
        //
        //
        // }


    }

    int n = 0;

    public int count(String s) {
        if (s.contains("a")) {
            n++;
            String temp = s.substring(s.indexOf("a") + 1);
            count(temp);
        }
        return n;
    }
}
