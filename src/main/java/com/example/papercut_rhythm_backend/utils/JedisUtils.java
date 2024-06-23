package com.example.papercut_rhythm_backend.utils;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 描述: Jedis工具类（封装了连接池）
 */
public class JedisUtils {

    private static final JedisPool jedisPool;

    static {
        // 配置连接池
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(5);
        config.setMaxIdle(3);
        config.setMinIdle(2);

        // 创建连接池
        jedisPool = new JedisPool(config, "localhost", 6379);
    }

    /**
     * 获取redis连接
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}