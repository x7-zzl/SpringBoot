package com.zzl;

import org.junit.jupiter.api.Test;
import org.objenesis.ObjenesisBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
//    @SuppressWarnings("all")
    private RedisTemplate redisTemplate; //高度封装的对象

    //string  test
    @Test
    public void testString() {
        System.out.println(redisTemplate);
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("ta", "ma");

        //指定超时时间,,10S
        redisTemplate.opsForValue().set("key1", "value1", 10L, TimeUnit.MINUTES);

        Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent("key2", "umr");
        System.out.println("setnx是否操作成功:" + aBoolean);


        System.out.println(ops.get("ta"));

        ops.set("yuhan5","21");
    }


    //hash test
    @Test
    void hash() {
        HashOperations hash = redisTemplate.opsForHash();
        //存值
        hash.put("001", "name", "zzl");
        hash.put("001", "age", "20");
        hash.put("001", "phone", "18337624145");

        //取值
        Object o = hash.get("001", "name");
        System.out.println(o);

        //获得hash结构中的所有字段
        Set keys = hash.keys("001");
        for (Object k : keys) {
            System.out.println("key:" + k);
        }

        //获得所有值
        List values = hash.values("001");
        for (Object v : values) {
            System.out.println("value:" + v);
        }


    }

    //list类型的数据
    @Test
    public void testList() {
        ListOperations listOperations = redisTemplate.opsForList();

        //存值
        listOperations.leftPush("mylist", "a");
        listOperations.leftPushAll("mylist", "b", "c", "d");

        //取值
        List<String> mylist = listOperations.range("mylist", 0, -1);
        for (String value : mylist) {
            System.out.println("value:"+value);
        }

        //获得列表长度 llen
        Long size = listOperations.size("mylist");
        int lSize = size.intValue();
        for (int i = 0; i < lSize; i++) {
            //出队列
            String element = (String) listOperations.rightPop("mylist");
            System.out.println(element);

        }

    }


    //set
    @Test
    public void testSet(){
        SetOperations setOperations = redisTemplate.opsForSet();

        //存值
        setOperations.add("myset","a","b","c","d");

        //查看
        Set myset = setOperations.members("myset");
        for (Object o1:myset){
            System.out.println("value1:"+o1);
        }

        //删除成员
        Long remove = setOperations.remove("myset", "a", "b");
        System.out.println("是否删除:"+remove);

        //查看
        myset = setOperations.members("myset");
        for (Object o1:myset){
            System.out.println("value2:"+o1);
        }
    }


    //zset
    @Test
    public void testZset(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();

        //存值
        zSetOperations.add("myZset","a",10.0);
        zSetOperations.add("myZset","b",11.0);
        zSetOperations.add("myZset","c",12.0);
        zSetOperations.add("myZset","a",13.0);

        //取值
        Set<String> myZset = zSetOperations.range("myZset", 0, -1);
        for (String s : myZset) {
            System.out.println(s);
        }

        //修改分数
        zSetOperations.incrementScore("myZset","b",20.0);

        //取值
        myZset = zSetOperations.range("myZset", 0, -1);
        for (String s : myZset) {
            System.out.println(s);
        }

        //删除成员
        zSetOperations.remove("myZset","a","b");

        //取值
        myZset = zSetOperations.range("myZset", 0, -1);
        for (String s : myZset) {
            System.out.println(s);
        }
    }


//    通用操作，针对不同的数据类型都可以操作
    @Test
    public void testCommon(){
        //获取Redis中所有的key
        Set<String> keys = redisTemplate.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }

        //判断某个key是否存在
        Boolean itcast = redisTemplate.hasKey("itcast");
        System.out.println(itcast);

        //删除指定key
        redisTemplate.delete("myZset");

        //获取指定key对应的value的数据类型
        DataType dataType = redisTemplate.type("myset");
        System.out.println(dataType.name());

    }


}
