package com.zzl;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

//StringRedisTemplate与本机的Redis互通
@SpringBootTest
public class StringRedisTemplateTest {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void testStringRedisGets(){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String s = ops.get("name");
        System.out.println(s);

    }

    @Test
    public void testStringRedisSet(){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set("red","blue");
        System.out.println("success");
    }


}
