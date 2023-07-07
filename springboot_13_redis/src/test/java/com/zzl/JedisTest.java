package com.zzl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.util.Set;

@SpringBootTest
public class JedisTest {

    @Test
    public void testJedis(){
        //1.获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2.进行具体的操作
        jedis.set("username","najisa");

        jedis.hset("myhash","address","bj");
        String hget = jedis.hget("myhash", "address");
        System.out.println(hget);

        Set<String> keys = jedis.keys("*");
        for (String key:keys) {
            System.out.println(key);
        }

        //3.关闭连接
        jedis.close();
    }
}
