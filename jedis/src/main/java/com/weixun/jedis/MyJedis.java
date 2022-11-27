package com.weixun.jedis;

import redis.clients.jedis.Jedis;

public class MyJedis {

    public static void main(String[] args) {
        // 1. new Jedis对象即可
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // jedis的所有方法就是redis命令的所有指令
        testPing(jedis );

        String money = jedis.get("money");
        System.out.println(money);

    }

    public static void testPing(Jedis jedis) {
        System.out.println(jedis.ping());
    }
}
