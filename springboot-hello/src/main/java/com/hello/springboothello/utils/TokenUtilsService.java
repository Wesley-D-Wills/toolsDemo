package com.hello.springboothello.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 创建用于操作Token相关的Service类，里面存在Token的创建与验证方法，其中
 *  1、Token创建方法：使用UUID工具创建Token，设置以"idempotent_token（幂等token）:" + "Token串"
 *      作为key，以用户信息当成value，将信息存入Redis中
 *  2、Token验证方法：接受Token串参数，加上Key前缀形成Key，再传入value值，执行Lua表达式
 *      （Lua表达式能保证命令执行的原子性）进行查找对应Key与删除操作。执行完成后，验证命令的返回结果，
 *      如果结果不为空且非0，则仰正成功，否则失败。
 */
@Slf4j
@Service
public class TokenUtilsService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 存入 Redis 的Token 键的前缀
     */
    private static final String IDEMPOTENT_TOKEN_PREFIX = "idempotent_token:";

    /**
     * 创建Token 存入 Redis，并返回该Token
     * @param value 用于辅助验证的value值
     * @return 生成的token
     */
    public String generateToken(String value) {
        // 实例化生成ID 工具对象
        String token = UUID.randomUUID().toString();
        // 设置存入Redis 的key
        String key = IDEMPOTENT_TOKEN_PREFIX + token;
        // 存储Token 到Redis中，且设置过期时间为5分钟
        redisTemplate.opsForValue().set(key, value, 5, TimeUnit.MINUTES);
        // 返回Token
        return token;
    }

    /**
     * 验证token的正确性
     *
     * @param token token字符串
     * @param value 存储在redis中的辅助验证信息
     * @return 验证结果
     */
    public boolean validToken(String token, String value) {
        // 设置Lua 脚本，其中KEYS[1] 是key，KEYS[2]是value
        String script = "if redis.call('get', KEYS[1]) == KEYS[2] then return redis.call('del', KEYS[1]) else return 0 end";
        RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
        String key = IDEMPOTENT_TOKEN_PREFIX + token;

        Long result = redisTemplate.execute(redisScript, Arrays.asList(key, value));

        if (result != null && result != 0L) {
            log.info("验证 token={}, key={}, value={} 成功", token, key, value);
            return true;
        }
        log.info("验证 token={}, key={}, value={} 失败", token, key, value);
        return false;
    }
}
